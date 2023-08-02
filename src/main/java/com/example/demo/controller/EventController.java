package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
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
    @LogActivity(value = "Post event")
    public ResponseEntity<EventDto> createEvent(@Valid @PathVariable long userId, @RequestBody EventDto eventDto) {
        EventDto createdEvent = eventService.createEvent(userId,eventDto);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/{eventId}")
    @LogActivity(value = "Update event")
    public ResponseEntity<EventDto> updateEvent(@Valid @PathVariable long userId, @PathVariable long eventId, @RequestBody EventDto eventDto) throws IllegalAccessException {
        EventDto updatedEvent = eventService.updateEvent(userId, eventId, eventDto);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{eventId}")
    @LogActivity(value = "Delete event")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @LogActivity(value = "Get all events")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    @LogActivity(value = "Get event")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        EventDto event = eventService.getEventById(eventId);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
