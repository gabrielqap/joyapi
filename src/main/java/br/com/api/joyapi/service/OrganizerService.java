package br.com.api.joyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.joyapi.entity.Organizer;
import br.com.api.joyapi.repository.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository repository;

    public Organizer create(Organizer organizer) {
        return repository.save(organizer);
    }

}
