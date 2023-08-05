package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.dto.userDto.AlumniPublic;
import org.springers.waa_alumniplatform.dto.userDto.FacultyProfile;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springers.waa_alumniplatform.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping("/{faculty_id}")
    public ResponseEntity<FacultyProfile> getOne(@PathVariable int faculty_id){
        return ResponseEntity.ok(facultyService.getFacultyProfileById(faculty_id));
    }

    @PutMapping("/{faculty_id}")
    public ResponseEntity<FacultyProfile> updateOne(@PathVariable int faculty_id, @RequestBody FacultyProfile facultyProfile, Principal principal){
        return ResponseEntity.ok(facultyService.updateById(principal, faculty_id, facultyProfile));
    }
}
