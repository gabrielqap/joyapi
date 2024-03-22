package br.com.api.joyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.joyapi.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByEventsId(Long eventId);
    Participant findByUsername(String username);
}
