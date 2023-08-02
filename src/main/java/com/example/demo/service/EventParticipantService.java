package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.EventParticipantDto;

import java.util.List;

public interface EventParticipantService {
    EventParticipantDto createEvent(long userId, EventParticipantDto event);

//    EventParticipantDto updateEvent(long userId, long eventId, EventParticipantDto event) throws IllegalAccessException;

    void deleteEventParticipant(long userId, long eventId);

    List<EventParticipantDto> getAllEventParticipants();

    EventParticipantDto getEventParticipantsByEventId(long eventId);
}
