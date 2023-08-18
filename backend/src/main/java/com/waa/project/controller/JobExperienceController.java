package com.waa.project.controller;

import com.waa.project.aspect.annotation.CheckUserActive;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.requestDto.ApiResponse;
import com.waa.project.dto.requestDto.ExperienceDto;
import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserRole;
import com.waa.project.service.JobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class JobExperienceController {
    private final JobExperienceService jobExperienceService;
    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }
    @LogMe
    @CheckUserActive
    @GetMapping
    public ResponseEntity<List<JobExperience>> getAllJobExperiences() {
        List<JobExperience> jobExperiences = jobExperienceService.getAllJobExperiences();
        return new ResponseEntity<>(jobExperiences, HttpStatus.OK);
    }
    @LogMe
    @CheckUserActive
    @PostMapping
    public ResponseEntity<JobExperience> createJobExperience(@RequestBody JobExperience jobExperience) {
        JobExperience createdJobExperience = jobExperienceService.createJobExperience(jobExperience);
        return new ResponseEntity<>(createdJobExperience, HttpStatus.CREATED);
    }

    @LogMe
    @CheckUserActive
    @GetMapping("/{id}")
    public ResponseEntity<JobExperience> getJobExperiences(@PathVariable long id) {
        JobExperience jobExperience = jobExperienceService.getJobExperiences(id);
        return new ResponseEntity<>(jobExperience, HttpStatus.OK);
    }
    @LogMe
    @CheckUserActive
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateJobExperience(@RequestBody ExperienceDto experienceDto, @PathVariable Long id) {
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        String updatejobAdvertisement = String.valueOf(jobExperienceService.updateJobExperience(experienceDto, id, loggedInUserEmail));

        if (updatejobAdvertisement != null) {
            ApiResponse<String> response = new ApiResponse<>(HttpStatus.CREATED.value(), "Job advertisement updated successfully.", updatejobAdvertisement);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            ApiResponse<String> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to update job advertisement.", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
