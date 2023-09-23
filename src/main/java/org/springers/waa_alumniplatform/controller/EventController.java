package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.Event;
import org.springers.waa_alumniplatform.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumnus/{alumni_Id}/events")
public class EventController {
    private final EventService eventService;

    @PatchMapping("/{event_id}/rsvp")
    public ResponseEntity<Event> rsvp(@PathVariable int event_id, @PathVariable int alumni_Id){
        return ResponseEntity.ok(eventService.rsvp(event_id, alumni_Id));
    }

    @PatchMapping("/{event_id}/attendance")
    public ResponseEntity<Event> attendance(@PathVariable int event_id, @PathVariable int alumni_Id){
        return ResponseEntity.ok(eventService.attendance(event_id, alumni_Id));
    }
    @GetMapping("/{event_id}")
    public ResponseEntity<Event> getOne(@PathVariable int event_id){
        return ResponseEntity.ok(eventService.getById(event_id));
    }

    @PostMapping
    public ResponseEntity<Event> addOne(@RequestBody Event event, @PathVariable int alumni_Id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventService.persist(event, alumni_Id));
    }

    @GetMapping ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(eventService.getAll());
    }
}
