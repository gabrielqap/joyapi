package br.com.api.joyapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.api.joyapi.entity.Participant;
import br.com.api.joyapi.entity.dto.ParticipantDTO;
import br.com.api.joyapi.repository.ParticipantRepository;

@Service
public class ParticipantService {
    @Autowired
	private static ParticipantRepository repository; 

    public List<ParticipantDTO> getParticipantsByEventId(Long eventId) {
        List<Participant> participants = repository.findByEventsId(eventId);
        return participants.stream()
                .map(participant -> new ParticipantDTO(participant.getName(), participant.getPhoto()))
                .collect(Collectors.toList());
    }

    public Participant create(Participant participant) {
        return repository.save(participant);
    }

    public Participant edit(Long participantId, Participant participant) {
        Participant foundParticipant = repository.findById(participantId).orElseThrow(() ->
         new ResourceAccessException("Event not Found"));

        foundParticipant.setName(participant.getName());
        foundParticipant.setPhoto(participant.getPhoto());
        foundParticipant.setGender(participant.getGender());
        foundParticipant.setBirthday(participant.getBirthday());
        
        Participant updateParticipant = repository.save(foundParticipant);
        return updateParticipant;
    }
}
