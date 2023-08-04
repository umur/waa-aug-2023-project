package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.dto.userDto.AlumniPublic;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/alumnus")
@RequiredArgsConstructor
public class AlumniController {
    private final AlumniService alumniService;

    @GetMapping("/filterByIndustry")
    public ResponseEntity<List<AlumniPublic>> getAlumnusByIndustry(@RequestParam String industry){
        return ResponseEntity.ok(alumniService.getAlumnusByIndustry(industry));
    }
    @GetMapping("/filterByGradYear")
    public ResponseEntity<List<AlumniPublic>> getAlumnusByGradYear(@RequestParam int year){
        return ResponseEntity.ok(alumniService.getAlumnusByGradYear(year));
    }
    @GetMapping("/filterByDept")
    public ResponseEntity<List<AlumniPublic>> getAlumnusByDept(@RequestParam String dept){
        return ResponseEntity.ok(alumniService.getAlumnusByDept(dept));
    }
    @GetMapping("/{alumni_id}")
    public ResponseEntity<AlumniProfile> getOne(@PathVariable int alumni_id){
        return ResponseEntity.ok(alumniService.getAlumniProfileById(alumni_id));
    }

    @PutMapping("/{alumni_id}")
    public ResponseEntity<AlumniProfile> updateOne(@PathVariable int alumni_id, @RequestBody AlumniProfile alumniProfile, Principal principal){
        System.out.println("Update one alumni controller reached");
        return ResponseEntity.ok(alumniService.updateById(principal, alumni_id, alumniProfile));
    }


}
