package br.com.api.joyapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.api.joyapi.entity.Event;
import br.com.api.joyapi.repository.EventRepository;

@Service
public class EventService {
    
    @Autowired
	private EventRepository repository; 

    public Object getAllEvents() {
        return repository.findAll();
    }

    public List<Event> getEventsByCityAndState(String city, String state) {
        return repository.findByCityAndState(city, state);
    }

    public List<Event> getEventsByCityStateAndPeriod(String city, String state, Date startDate, Date endDate){
        return repository.findByCityAndStateAndDateBetween(city, state, startDate, endDate);
    }


    public List<Event> findEventsByOrganizerPeriod(Long organizerId, Date startDate, Date endDate) {
        return repository.findByOrganizerIdAndDateBetween(organizerId, startDate, endDate);
    }

    public Event create(Event event){
        return repository.save(event);
    }

    public Event update(Long eventId, Event event) {
        Event foundEvent = repository.findById(eventId).orElseThrow(() ->
         new ResourceAccessException("Event not Found"));

        foundEvent.setName(event.getName());
        foundEvent.setAdress(event.getAdress());
        foundEvent.setCity(event.getCity());
        foundEvent.setState(event.getState());
        foundEvent.setDate(event.getDate());
        foundEvent.setDescription(event.getDescription());
        
        Event updateEvent = repository.save(foundEvent);
        return updateEvent;
    }

    public void delete(Long eventId) {
        repository.deleteById(eventId);
    }
    
}
