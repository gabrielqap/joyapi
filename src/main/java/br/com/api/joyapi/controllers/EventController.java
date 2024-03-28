package br.com.api.joyapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

	
	@GetMapping("/")
	public ResponseEntity<Object> getAll() {
		var events = eventService.getAllEvents();
		return ResponseEntity.ok(events);
	}
	
	@GetMapping("/by_city_state")
	public ResponseEntity<Object> getByCityAndState(@RequestParam String city,
            @RequestParam String state) {
        try {
            var events = eventService.getEventsByCityAndState(city, state);
            if (!events.isEmpty()) {
                return ResponseEntity.ok(events);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@GetMapping("/by_city_state_period")
	public ResponseEntity<Object> getEventsByCityStateAndPeriod(
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            List<Event> events = eventService.getEventsByCityStateAndPeriod(city, state, startDate, endDate);
            if (!events.isEmpty()) {
                return ResponseEntity.ok(events);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/by_organizer_period")
    public ResponseEntity<Object> getEventsByOrganizer(@RequestParam Long organizerId, 
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            List<Event> events = eventService.findEventsByOrganizerPeriod(organizerId, startDate, endDate);
            if (!events.isEmpty()) {
                return ResponseEntity.ok(events);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createEvent(@RequestBody Event event){
        try {
            Event savedEvent = eventService.create(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Object> editEvent(@PathVariable Long eventId,
     @RequestBody Event event){
        try{
            Event updatedEvent = eventService.update(eventId, event); 
            return ResponseEntity.ok(updatedEvent);   
        } catch (ResourceAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long eventId) {
        try {
            eventService.delete(eventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
