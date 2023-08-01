package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumni/{alumni_id}")
@RequiredArgsConstructor
public class AlumniController {
    private final AlumniService alumniService;
    @GetMapping
    public ResponseEntity<AlumniProfile> getOne(@PathVariable int alumni_id){
        return ResponseEntity.ok(alumniService.getById(alumni_id));
    }

    @PutMapping
    public ResponseEntity<AlumniProfile> updateOne(@PathVariable int alumni_id, @RequestBody AlumniProfile alumniProfile){
        return ResponseEntity.ok(alumniService.updateById(alumni_id, alumniProfile));
    }
}
