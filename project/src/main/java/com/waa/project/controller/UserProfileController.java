package com.waa.project.controller;

import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserProfile;
import com.waa.project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable long id){
        UserProfile getUserprofile = userProfileService.getUserProfile(id);
        return ResponseEntity.ok(getUserprofile);
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfile(){
        List<UserProfile> getUserprofile = userProfileService.getAllUserProfile();
        return ResponseEntity.ok(getUserprofile);
    }

    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
        return ResponseEntity.ok(createdUserProfile);
    }
    @PostMapping("/{userProfileId}/job-experience")
    public ResponseEntity<String> addJobExperienceToUserProfile(
            @PathVariable int userProfileId,
            @RequestBody JobExperience jobExperience) {
        try {
            userProfileService.addJobExperienceToUserProfile(userProfileId, jobExperience);
            return ResponseEntity.ok("Job experience added to the user profile.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
