package br.com.api.joyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.joyapi.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
}
