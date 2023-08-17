package com.example.springproject.controller;

import com.example.springproject.entity.Job;
import com.example.springproject.service.JobService;
import com.example.springproject.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JobController {
    private final JobService jobService;


    @GetMapping
    @JsonView(Views.JobControllerView.class)
    public List<Job> get(){
        return jobService.findAll();
    }
    @JsonView(Views.JobControllerView.class)
    @GetMapping("/{id}")
    public Job getById(@PathVariable int id) {
    	return jobService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Job job) {
        jobService.add(job);
        return ResponseEntity.ok("post is working correctly");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        jobService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Job job){
        jobService.update(job);
        return ResponseEntity.ok("update is working correctly");

    }

    @PutMapping("/apply/{jobId}/{studentId}")
    public ResponseEntity<String> apply(@PathVariable int jobId, @PathVariable int studentId){
        jobService.apply(jobId, studentId);
        return ResponseEntity.ok("update is working correctly");
    }

}
