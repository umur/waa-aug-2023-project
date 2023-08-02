package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Validated
public class EventController {

    @Autowired
    private  EventService eventService;



    @PostMapping("/{userId}")
    public ResponseEntity<EventDto> createEvent(@Valid @PathVariable long userId, @RequestBody EventDto eventDto) {
        EventDto createdEvent = eventService.createEvent(userId,eventDto);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@Valid @PathVariable long userId, @PathVariable long eventId, @RequestBody EventDto eventDto) throws IllegalAccessException {
        EventDto updatedEvent = eventService.updateEvent(userId, eventId, eventDto);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        EventDto event = eventService.getEventById(eventId);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
