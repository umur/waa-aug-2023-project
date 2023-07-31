package com.example.demo.controller;

import com.example.demo.dto.JobExpDto;
import com.example.demo.service.JobExpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-experiences")
@RequiredArgsConstructor
public class JobExperienceController {
    @Autowired
    private final JobExpService jobExpService;



    @PostMapping
    public ResponseEntity<JobExpDto> createJobExperience(@RequestBody JobExpDto jobExpDto) {
        JobExpDto createdJobExperience = jobExpService.createJobExperience(jobExpDto);
        return new ResponseEntity<>(createdJobExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{jobExperienceId}")
    public ResponseEntity<JobExpDto> updateJobExperience(
            @PathVariable Long jobExperienceId,
            @RequestBody JobExpDto jobExperienceDto
    ) {
        JobExpDto updatedJobExperience = jobExpService.updateJobExperience(jobExperienceId, jobExperienceDto);
        if (updatedJobExperience != null) {
            return new ResponseEntity<>(updatedJobExperience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{jobExperienceId}")
    public ResponseEntity<Void> deleteJobExperience(@PathVariable Long jobExperienceId) {
        jobExpService.deleteJobExperience(jobExperienceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<JobExpDto>> getAllJobExperiences() {
        List<JobExpDto> jobExperienceList = jobExpService.getAllJobExperiences();
        return new ResponseEntity<>(jobExperienceList, HttpStatus.OK);
    }

    @GetMapping("/{jobExperienceId}")
    public ResponseEntity<JobExpDto> getJobExperienceById(@PathVariable Long jobExperienceId) {
        JobExpDto jobExperience = jobExpService.getJobExperienceById(jobExperienceId);
        if (jobExperience != null) {
            return new ResponseEntity<>(jobExperience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
