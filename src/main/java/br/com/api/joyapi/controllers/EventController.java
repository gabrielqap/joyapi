package br.com.api.joyapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.ResourceAccessException;

import br.com.api.joyapi.entity.Event;
import br.com.api.joyapi.service.EventService;

@Controller
@RequestMapping("/event")
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

	@GetMapping("/by_organizer_period")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@RequestParam Long organizerId, 
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Event> events = EventService.findEventsByOrganizerPeriod(organizerId, startDate, endDate);
        if (!events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        try {
            Event savedEvent = EventService.create(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> editEvent(@PathVariable Long eventId,
     @RequestBody Event event){
        try{
            Event updatedEvent = EventService.update(eventId, event); 
            return ResponseEntity.ok(updatedEvent);   
        } catch (ResourceAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long eventId) {
        try {
            EventService.delete(eventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
