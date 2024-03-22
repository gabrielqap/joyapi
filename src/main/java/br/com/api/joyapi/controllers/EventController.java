package br.com.api.joyapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.api.joyapi.entity.Event;
import br.com.api.joyapi.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {	
	
	@GetMapping("/")
	public ResponseEntity<Object> getAll() {
		var events = EventService.getAllEvents();
		return ResponseEntity.ok(events);
	}
	
	@GetMapping("/by_city_state")
	public ResponseEntity<List<Event>> getByCityAndState(@RequestParam String city,
            @RequestParam String state) {
		var events = EventService.getEventsByCityAndState(city, state);
		if (!events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

	@GetMapping("/by_city_state_period")
	public ResponseEntity<List<Event>> getEventsByCityStateAndPeriod(
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Event> events = EventService.getEventsByCityStateAndPeriod(city, state, startDate, endDate);
        if (!events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@GetMapping("/by_organizer")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@RequestParam Long organizerId) {
        List<Event> events = EventService.findEventsByOrganizer(organizerId);
        if (!events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
