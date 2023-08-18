package com.example.projectmid.Controller;

import com.example.projectmid.Entities.Event;
import com.example.projectmid.Services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
//comment /// make the alumni manage the events through security;;;
public class EventController {
    private final EventService eventService;

    @PostMapping
    public void createEvent(@RequestBody Event event){
        eventService.save(event);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Event event){
        eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        eventService.deleteById(id);
    }

    @GetMapping
    public List<Event> findAll(){
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Event findById(@PathVariable int id){
        return eventService.findById(id);
    }
}
