package com.example.demo.controller;


import com.example.demo.dto.EventParticipantDto;
import com.example.demo.service.EventParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventParticipants")
@CrossOrigin
public class EventParticipantController {
    @Autowired
    private EventParticipantService eventParticipantService;

    @PostMapping("/{userId}")
    public ResponseEntity<EventParticipantDto> createEventParticipant(
            @PathVariable long userId,
            @RequestBody EventParticipantDto eventParticipantDto
    ) {
        EventParticipantDto createdEventParticipant = eventParticipantService.createEvent(userId, eventParticipantDto);
        return new ResponseEntity<>(createdEventParticipant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{eventId}")
    public ResponseEntity<Void> deleteEventParticipant(@PathVariable long userId, @PathVariable long eventId) {
        eventParticipantService.deleteEventParticipant(userId, eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EventParticipantDto>> getAllEventParticipants() {
        List<EventParticipantDto> eventParticipants = eventParticipantService.getAllEventParticipants();
        return new ResponseEntity<>(eventParticipants, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventParticipantDto> getEventParticipantByEventId(@PathVariable long eventId) {
        EventParticipantDto eventParticipant = eventParticipantService.getEventParticipantsByEventId(eventId);
        return new ResponseEntity<>(eventParticipant, HttpStatus.OK);
    }
}
