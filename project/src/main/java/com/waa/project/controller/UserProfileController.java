package com.waa.project.controller;

import com.waa.project.entity.JobExperience;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import com.waa.project.service.UserProfileService;
import com.waa.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserService userService;

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


    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody UserProfile updatedProfile, Principal principal) {
        // Get the authenticated user's email (unique identifier)
        String userEmail = principal.getName();

        // Find the user by email
        User user = userService.findByEmail(userEmail);

        // Check if the user exists and the associated profile is not null
        if (user == null || user.getProfile() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User or profile not found.");
        }

        // Check if the user role is either FACULTY or ALUMNI (Students can also edit their profiles)
        if (user.getUserRole() == UserRole.FACULTY || user.getUserRole() == UserRole.ALUMNI) {
            // Check if the profile being updated belongs to the authenticated user
            if (!user.getProfile().getId().equals(updatedProfile.getId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can only edit your own profile.");
            }
        }

        // Perform the actual update here (you might need to add some validation or sanitation)

        // Save the updated profile
        userService.saveUserProfile(updatedProfile);

        return ResponseEntity.ok("Profile updated successfully.");
    }
}
