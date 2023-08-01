package com.waa.project.controller;

import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserRepository userRepository;
    @LogMe
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable long id){
        UserProfile getUserprofile = userProfileService.getUserProfile(id);
        return ResponseEntity.ok(getUserprofile);
    }
    @LogMe
    @PreAuthorize("hasRole('ALUMNI')")
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfile(){
        List<UserProfile> getUserprofile = userProfileService.getAllUserProfile();
        return ResponseEntity.ok(getUserprofile);
    }
    @LogMe
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
        return ResponseEntity.ok(createdUserProfile);
    }
    @LogMe
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
    @LogMe
    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody UserProfile updatedProfile, Authentication authentication) {
        // Get the authenticated user's email (unique identifier)

        // Find the user by email
        User user = (User)authentication.getPrincipal();

        user.getProfile().setFirstName(updatedProfile.getFirstName());
        user.getProfile().setLastName(updatedProfile.getLastName());



        // Perform the actual update here (you might need to add some validation or sanitation)

        // Save the updated profile
//        userService.saveUserProfile(updatedProfile);

        return ResponseEntity.ok(UsersDto.fromUser( userRepository.save(user)));
    }
}
