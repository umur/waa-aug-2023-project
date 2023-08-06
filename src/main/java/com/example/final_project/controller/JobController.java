package com.example.final_project.controller;
import com.example.final_project.dto.JobDto;
import com.example.final_project.service.imp.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.final_project.dto.ResponseMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<ResponseMessage> add(@RequestBody JobDto job){
        jobService.add(job);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully added job"));
    }
    @GetMapping
    public ResponseEntity<Object> get(){
        return ResponseEntity.ok(jobService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(jobService.findById(id));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getByUserId(@PathVariable Long id){
        return ResponseEntity.ok(jobService.findJobByÙser(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> update(@RequestBody JobDto job, @PathVariable Long id){
        jobService.updateJob(job,id);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully updated job"));
    }
    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable Long id){
        jobService.deleteJob(id);
        return ResponseEntity.ok(new ResponseMessage(true,"removed correctly"));
    }
}
