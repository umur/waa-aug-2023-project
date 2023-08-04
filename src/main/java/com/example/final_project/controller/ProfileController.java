package com.example.final_project.controller;

import com.example.final_project.dto.ProfileDto;
import com.example.final_project.service.imp.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @PostMapping
    public void addProfile(@RequestBody ProfileDto profileDto, HttpServletRequest request) {
        profileService.add(profileDto, request);
    }
    @GetMapping
    public ProfileDto getProfile(HttpServletRequest request) {
        return profileService.findById(request);
    }
    @PutMapping
    public void updateProfile(@RequestBody ProfileDto profileDto, HttpServletRequest request) {
        profileService.update(profileDto, request);
    }
    @DeleteMapping
    public void deleteProfile(HttpServletRequest request) {
        profileService.delete(request);
    }
}
