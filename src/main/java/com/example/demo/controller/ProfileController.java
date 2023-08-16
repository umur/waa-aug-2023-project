package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.ProfileDto;
import com.example.demo.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profiles")
@Validated
@CrossOrigin(origins = "*")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    @LogActivity(value = "Post profile")
    public ResponseEntity<ProfileDto> save(@Valid @RequestBody ProfileDto profileDto){
        ProfileDto createdProfile = profileService.save(profileDto);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping
    @LogActivity(value = "Get all profiles")
    public ResponseEntity<List<ProfileDto>> getAll(){
        List<ProfileDto> profileDtoList = profileService.getAll();
        return ResponseEntity.ok(profileDtoList);
    }

    @GetMapping("/{id}")
    @LogActivity(value = "Get profile")
    public ResponseEntity<ProfileDto> getById(@PathVariable Long id){
        ProfileDto profileDto = profileService.getById(id);
        if(profileDto != null) return ResponseEntity.ok(profileDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @LogActivity(value = "Update profile")
    public ResponseEntity<ProfileDto> update(@Valid @PathVariable Long id, @RequestBody ProfileDto profileDto){
        ProfileDto updatedProfile = profileService.update(profileDto, id);
        if(updatedProfile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        boolean deleted = profileService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search-by-year")
    public ResponseEntity<List<ProfileDto>> searchByGraduationYear(@RequestParam Integer graduationYear) {
        return ResponseEntity.ok(profileService.getProfilesByGraduationYear(graduationYear));
    }

    @GetMapping("/search-by-city")
    public ResponseEntity<List<ProfileDto>> searchByCity(@RequestParam String city) {
        return ResponseEntity.ok(profileService.searchByCity(city));
    }

    @GetMapping("/search-by-state")
    public ResponseEntity<List<ProfileDto>> searchByState(@RequestParam String state) {
        return ResponseEntity.ok(profileService.searchByState(state));
    }
}
