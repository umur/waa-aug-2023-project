package com.waa.project.controller;

import com.waa.project.aspect.annotation.CheckUserActive;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.entity.JobExperience;
import com.waa.project.service.JobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
