package com.example.springproject.controller;

import com.example.springproject.entity.Event;
import com.example.springproject.entity.Student;
import com.example.springproject.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventController {
    private final EventService eventService;


    @PostMapping
    public ResponseEntity<String> add(@RequestBody Event event) {
        eventService.add(event);
        return ResponseEntity.ok("post is working correctly");
    }
    @PostMapping("/rsvp/{event_id}")
    public ResponseEntity<String> RSVP(@PathVariable int event_id, @RequestBody Student student){
        eventService.RSVP(event_id, student);
        return ResponseEntity.ok("post is working correctly");

    }
    @GetMapping
    public List<Event> get() {
        return eventService.findAll();
    }
    
    @GetMapping("/{id}")
    public Event getById(@PathVariable int id) {
    	return eventService.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        eventService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Event Event){
        eventService.update(Event);
        return ResponseEntity.ok("update is working correctly");

    }

}
