package br.com.api.joyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.api.joyapi.entity.Organizer;
import br.com.api.joyapi.service.OrganizerService;

@Controller
@RequestMapping("/organizer")
public class OrganizerController {
    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }
    
    @PostMapping("")
    public ResponseEntity<Object> createOrganizer(@RequestBody Organizer organizer){
        try {
            Organizer savedOrganizer = organizerService.create(organizer);
            return new ResponseEntity<>(savedOrganizer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getOrganizer(){
        try {
            var organizers = organizerService.getAll();
		    return ResponseEntity.ok(organizers);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
