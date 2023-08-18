package com.example.projectmid.Controller;


import com.example.projectmid.Entities.Admin;
import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Services.AdminService;
import com.example.projectmid.Services.AlumniService;
import com.example.projectmid.Services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/alumni")
@AllArgsConstructor
public class AlumniController {
    private final AlumniService alumniService;
    private final EventService eventService;
    private final AdminService adminService;

    @PostMapping
    public void createalmuni(@RequestBody Alumni alumni){
        alumniService.save(alumni);
    }
    //update
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Alumni almuni){
        alumniService.update(id, almuni);
    }
    //Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        alumniService.deleteById(id);
    }
    @GetMapping
    public List<Alumni> findAll(){
        List<Alumni> LA = alumniService.findAll();
        return LA;
    }
    @GetMapping("/{id}")
    public Alumni findById(@PathVariable int id){
        return alumniService.findById(id);
    }

    @GetMapping("/by-year/{year}")
    public List<Alumni> findAllByGraduationYear(@PathVariable int year){
        return alumniService.findAllByGraduationYear(year);
    }
    @GetMapping("/by-location/{location}")
    public List<Alumni> findAllByLocationEquals(String location){
        return alumniService.findAllByLocationEquals(location);
    }
    // return a list of attendence from events:
    @GetMapping("/event-attendence/{event_id}")
    public List<Alumni> findAlumniByEvent(int event_id){
        return eventService.findAlumniByEvent(event_id);
    }

}
