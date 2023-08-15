package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.JobDto;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jobs")
@Validated
@CrossOrigin
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    @LogActivity(value = "Post job")
    public ResponseEntity<JobDto> save(@Valid @RequestBody JobDto jobDto){
        JobDto createdJob = jobService.save(jobDto);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping
    @LogActivity(value = "Get all jobs")
    public ResponseEntity<List<JobDto>> getAll(){
        List<JobDto> jobDtoList = jobService.getAll();
        return ResponseEntity.ok(jobDtoList);
    }

    @GetMapping("/{id}")
    @LogActivity(value = "Get job")
    public ResponseEntity<JobDto> getById(@PathVariable Long id){
        JobDto jobDto = jobService.getById(id);
        if(jobDto != null) return ResponseEntity.ok(jobDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @LogActivity(value = "Update job")
    public ResponseEntity<JobDto> update(@Valid @PathVariable Long id, @RequestBody JobDto jobDto){
        JobDto updatedJob = jobService.update(jobDto, id);
        if(updatedJob == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{id}")
    @LogActivity(value = "Delete job")
    public ResponseEntity delete(@PathVariable Long id){
        boolean deleted = jobService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}
