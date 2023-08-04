package com.example.final_project.controller;

import com.example.final_project.dto.EventDto;
import com.example.final_project.dto.FeedBackDto;
import com.example.final_project.entity.Event;
import com.example.final_project.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")

public class EventController {
    private final EventService eventService;

    @GetMapping
    List<EventDto> getAll(){
        System.out.println("in controller");
        return eventService.getAllEvents();
    }
    @GetMapping("/{id}")
    EventDto getById(@PathVariable Long id){
        return eventService.getEventById(id);
    }
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteEvent(@PathVariable Long id){
         eventService.deleteEvent(id);
    return ResponseEntity.ok().body("created successfully");

}
@PostMapping
public ResponseEntity<String> save(@RequestBody EventDto event){
        eventService.save(event);
    return ResponseEntity.ok().body("created successfully");

}

@PutMapping
public ResponseEntity<String>  update(@RequestBody EventDto event){
        eventService.update(event);
        return ResponseEntity.ok().body("updated successfully");

}

    @PostMapping("/{userId}")
    public ResponseEntity<String> save2(@RequestBody EventDto dto, @PathVariable Long userId){
        eventService.save2(dto, userId);
        return ResponseEntity.ok().body("created successfully");
    }
}
