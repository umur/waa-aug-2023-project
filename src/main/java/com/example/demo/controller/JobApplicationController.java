package com.example.demo.controller;

import com.example.demo.dto.JobApplicationDto;
import com.example.demo.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-applications")
@Validated
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping
    public ResponseEntity<JobApplicationDto> save(@RequestBody JobApplicationDto jobApplicationDto){
        JobApplicationDto jobApplication = jobApplicationService.save(jobApplicationDto);
        return new ResponseEntity<>(jobApplication, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobApplicationDto>> getAll(){
        List<JobApplicationDto> jobApplicationDtoList = jobApplicationService.getAll();
        return ResponseEntity.ok(jobApplicationDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationDto> getById(@PathVariable int id){
        JobApplicationDto jobApplicationDto = jobApplicationService.getById(id);
        if(jobApplicationDto != null) return ResponseEntity.ok(jobApplicationDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationDto> update(@PathVariable int id, @RequestBody JobApplicationDto jobApplicationDto){
        JobApplicationDto updatedJobApplication = jobApplicationService.update(jobApplicationDto, id);
        if(updatedJobApplication == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJobApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean deleted = jobApplicationService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
