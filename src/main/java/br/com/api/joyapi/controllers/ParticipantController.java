package br.com.api.joyapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.api.joyapi.entity.Participant;
import br.com.api.joyapi.entity.dto.ParticipantDTO;
import br.com.api.joyapi.service.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {
    @GetMapping("/by_event")
	public ResponseEntity<List<ParticipantDTO>> getByCityAndState(@RequestParam Long eventId) {
		var participants = ParticipantService.getParticipantsByEventId(eventId);
		if (!participants.isEmpty()) {
            return ResponseEntity.ok(participants);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

    @PostMapping("/")
    public ResponseEntity<Participant> createParticipant(@RequestParam Participant participant){
        try {
            Participant savedParticipant = ParticipantService.create(participant);
            return new ResponseEntity<>(savedParticipant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{participantId}")
    public ResponseEntity<Participant> editParticipant(@PathVariable Long participantId, 
        @RequestParam Participant participant){
        try {
            Participant savedParticipant = ParticipantService.edit(participantId, participant);
            return new ResponseEntity<>(savedParticipant, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
