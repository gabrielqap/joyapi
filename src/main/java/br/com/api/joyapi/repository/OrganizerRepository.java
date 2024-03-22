package br.com.api.joyapi.repository;

import br.com.api.joyapi.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    Organizer findByUsername(String username);
}
