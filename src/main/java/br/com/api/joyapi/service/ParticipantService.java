package br.com.api.joyapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.joyapi.entity.Participant;
import br.com.api.joyapi.entity.dto.ParticipantDTO;
import br.com.api.joyapi.repository.ParticipantRepository;

public class ParticipantService {
    @Autowired
	private static ParticipantRepository repository; 

    public static List<ParticipantDTO> getParticipantsByEventId(Long eventId) {
        List<Participant> participants = repository.findByEventsId(eventId);
        return participants.stream()
                .map(participant -> new ParticipantDTO(participant.getName(), participant.getPhoto()))
                .collect(Collectors.toList());
    }
}
