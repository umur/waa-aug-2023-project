package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;

import java.util.List;

public interface EventService {
    EventDto createEvent(long userId,EventDto event);

    EventDto updateEvent(long userId, long eventId, EventDto event) throws IllegalAccessException;

    void deleteEvent(long eventId);

    List<EventDto> getAllEvents();

    EventDto getEventById(long eventId);
}
