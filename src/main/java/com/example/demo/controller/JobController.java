package com.example.demo.controller;

import com.example.demo.dto.JobDto;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> save(@RequestBody JobDto jobDto){
        JobDto createdJob = jobService.save(jobDto);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAll(){
        List<JobDto> jobDtoList = jobService.getAll();
        return ResponseEntity.ok(jobDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getById(@PathVariable int id){
        JobDto jobDto = jobService.getById(id);
        if(jobDto != null) return ResponseEntity.ok(jobDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobDto> update(@PathVariable int id, @RequestBody JobDto jobDto){
        JobDto updatedJob = jobService.update(jobDto, id);
        if(updatedJob == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean deleted = jobService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}
