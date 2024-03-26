package br.com.api.joyapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.joyapi.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findByCityAndState(String city, String state);
    List<Event> findByCityAndStateAndDateBetween(String city, String state, Date startDate, Date endDate);
    List<Event> findByOrganizerIdAndDateBetween(Long organizerId, Date startDate, Date endDate);
}
