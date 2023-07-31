package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto event);

    EventDto updateEvent(Long eventId, EventDto event);

    void deleteEvent(Long eventId);

    List<EventDto> getAllEvents();

    EventDto getEventById(Long eventId);
}
