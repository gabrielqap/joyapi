package br.com.api.joyapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
