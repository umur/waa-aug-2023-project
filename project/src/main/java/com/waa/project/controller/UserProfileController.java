package com.waa.project.controller;

import com.waa.project.aspect.annotation.CheckUserActive;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.UserProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @LogMe
    @CheckUserActive
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable long id){
        UserProfile getUserprofile = userProfileService.getUserProfile(id);
        return ResponseEntity.ok(getUserprofile);
    }
    @LogMe
    @CheckUserActive
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfile(){
        List<UserProfile> getUserprofile = userProfileService.getAllUserProfile();
        return ResponseEntity.ok(getUserprofile);
    }
    @LogMe
    @CheckUserActive
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
        return ResponseEntity.ok(createdUserProfile);
    }
    @LogMe
    @CheckUserActive
    @PostMapping("/{userProfileId}/experience")
    public ResponseEntity<String> addJobExperienceToUserProfile(
            @PathVariable long userProfileId,
            @RequestBody JobExperience jobExperience) {
        try {
            userProfileService.addJobExperienceToUserProfile(userProfileId, jobExperience);
            return ResponseEntity.ok("Job experience added to the user profile.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @LogMe
    @CheckUserActive
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody UpdatedProfileDto updatedProfileDto, Authentication authentication) {
        try {
            userProfileService.updateUserProfile(id, updatedProfileDto);
            return ResponseEntity.ok("User profile updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User profile not found with ID: " + id);
        }
    }
}
