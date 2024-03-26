package br.com.api.joyapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.joyapi.entity.Organizer;
import br.com.api.joyapi.repository.OrganizerRepository;

public class OrganizerService {
    @Autowired
    private static OrganizerRepository repository;

    public static Organizer create(Organizer organizer) {
        return repository.save(organizer);
    }
    

}
