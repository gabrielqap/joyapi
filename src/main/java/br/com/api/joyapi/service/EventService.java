package br.com.api.joyapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.joyapi.entity.Event;
import br.com.api.joyapi.repository.EventRepository;

public class EventService {
    
    @Autowired
	private static EventRepository repository; 

    public static Object getAllEvents() {
        return repository.findAll();
    }

    public static List<Event> getEventsByCityAndState(String city, String state) {
        return repository.findByCityAndState(city, state);
    }

    public static List<Event> getEventsByCityStateAndPeriod(String city, String state, Date startDate, Date endDate){
        return repository.findByCityAndStateAndDateBetween(city, state, startDate, endDate);
    }


    public static List<Event> findEventsByOrganizer(Long organizerId) {
        return repository.findByOrganizerId(organizerId);
    }
    
}
