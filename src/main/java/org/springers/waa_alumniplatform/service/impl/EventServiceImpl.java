package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Event;
import org.springers.waa_alumniplatform.exception.EntityNotFound;
import org.springers.waa_alumniplatform.repository.EventRepo;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springers.waa_alumniplatform.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;
    private final AlumniService alumniService;
    @Override
    public Event persist(Event event, int alumniId) {
        Alumni alumni = alumniService.getAlumniById(alumniId);
        event.setPoster(alumni);
        return eventRepo.save(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event getById(int eventId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(()-> new EntityNotFound("Event not found"));
        return event;
    }

    @Override
    public Event rsvp(int eventId, int alumniId) {
        Event event = getById(eventId);
        Alumni alumni = alumniService.getAlumniById(alumniId);
        event.getRsvpList().add(alumni);
        eventRepo.save(event);
        return event;
    }

    @Override
    public Event attendance(int eventId, int alumniId) {
        Event event = getById(eventId);
        Alumni alumni = alumniService.getAlumniById(alumniId);
        event.getAttendees().add(alumni);
        eventRepo.save(event);
        return event;
    }
}
