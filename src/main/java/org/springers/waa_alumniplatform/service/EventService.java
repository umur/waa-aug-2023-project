package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.entity.Event;

import java.util.List;

public interface EventService {
    Event persist(Event event, int alumniId);

    List<Event> getAll();

    Event getById(int eventId);

    Event rsvp(int eventId, int alumniId);

    Event attendance(int eventId, int alumniId);
}
