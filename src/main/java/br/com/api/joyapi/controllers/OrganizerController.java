package br.com.api.joyapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.api.joyapi.entity.Organizer;
import br.com.api.joyapi.service.OrganizerService;

@Controller
@RequestMapping("/organizer")
public class OrganizerController {
    
    @PostMapping("/")
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer){
        try {
            Organizer savedOrganizer = OrganizerService.create(organizer);
            return new ResponseEntity<>(savedOrganizer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
