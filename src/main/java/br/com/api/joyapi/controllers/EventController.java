package br.com.api.joyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.api.joyapi.repository.EventRepository;

@Controller
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventRepository repository; 	
	
	@GetMapping
	public ResponseEntity getAllEvents() {
		var allEvents = repository.findAll();
		return ResponseEntity.ok(allEvents);
	}

}
