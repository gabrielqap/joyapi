package br.com.api.joyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.api.joyapi.entity.Organizer;
import br.com.api.joyapi.entity.Participant;
import br.com.api.joyapi.entity.Person;
import br.com.api.joyapi.entity.dto.PersonDTO;
import br.com.api.joyapi.repository.OrganizerRepository;
import br.com.api.joyapi.repository.ParticipantRepository;

public class LoginService {
    @Autowired
    private static ParticipantRepository participantRepository;
    
    @Autowired
    private static OrganizerRepository organizerRepository;
    
//private static PasswordEncoder passwordEncoder;

    public static Person authenticateUser(PersonDTO personDTO) {
        String username = personDTO.getUsername();
        String password = personDTO.getPassword();
        String type = personDTO.getType();

        if (type == "participant"){
            Participant participant = participantRepository.findByUsername(username);
           /*  if(participant != null && passwordEncoder.matches(password, participant.getPassword())) {
                return participant;
            }
            return null;
        } else if(type == "organizer"){
            Organizer organizer = organizerRepository.findByUsername(username);
            if (organizer != null && passwordEncoder.matches(password, organizer.getPassword())) {
                return organizer; 
            }/* */
            return null;
        }
        return null;
    }
}
