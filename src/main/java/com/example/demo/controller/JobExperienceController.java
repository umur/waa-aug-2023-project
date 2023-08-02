package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.JobExpDto;
import com.example.demo.service.JobExpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-experiences")
@Validated
public class JobExperienceController {

    @Autowired
    private  JobExpService jobExpService;



    @PostMapping("/{profileId}")
    @LogActivity(value = "Post job experience")
    public ResponseEntity<JobExpDto> createJobExperience(@Valid @PathVariable long profileId, @RequestBody JobExpDto jobExpDto) {
        JobExpDto createdJobExperience = jobExpService.createJobExperience(profileId,jobExpDto);
        return new ResponseEntity<>(createdJobExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{profileId}/{jobExperienceId}")
    @LogActivity(value = "Update job experience")
    public ResponseEntity<JobExpDto> updateJobExperience(
            @Valid
            @PathVariable long profileId,
            @PathVariable long jobExperienceId,
            @RequestBody JobExpDto jobExperienceDto
    ) throws IllegalAccessException {
        JobExpDto updatedJobExperience = jobExpService.updateJobExperience(profileId, jobExperienceId, jobExperienceDto);
        if (updatedJobExperience != null) {
            return new ResponseEntity<>(updatedJobExperience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{jobExperienceId}")
    @LogActivity(value = "Delete job experience")
    public ResponseEntity<Void> deleteJobExperience(@PathVariable long jobExperienceId) {
        jobExpService.deleteJobExperience(jobExperienceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @LogActivity(value = "Get all job experiences")
    public ResponseEntity<List<JobExpDto>> getAllJobExperiences() {
        List<JobExpDto> jobExperienceList = jobExpService.getAllJobExperiences();
        return new ResponseEntity<>(jobExperienceList, HttpStatus.OK);
    }

    @GetMapping("/{jobExperienceId}")
    @LogActivity(value = "Get job experience")
    public ResponseEntity<JobExpDto> getJobExperienceById(@PathVariable long jobExperienceId) {
        JobExpDto jobExperience = jobExpService.getJobExperienceById(jobExperienceId);
        if (jobExperience != null) {
            return new ResponseEntity<>(jobExperience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
