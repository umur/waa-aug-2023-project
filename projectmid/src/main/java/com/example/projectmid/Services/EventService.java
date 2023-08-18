package com.example.projectmid.Services;

import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Entities.Event;
import com.example.projectmid.Repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void update(Integer id, Event event) {
        event.setId(id);
        eventRepository.save(event);
    }

    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Alumni> findAlumniByEvent(int eventId) {
        return eventRepository.findAlumniByEvent(eventId);
    }
}
