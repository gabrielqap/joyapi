package br.com.api.joyapi.repository;

import br.com.api.joyapi.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    Organizer findByUserUsername(String username);
}
