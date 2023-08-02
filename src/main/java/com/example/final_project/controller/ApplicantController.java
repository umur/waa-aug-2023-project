package com.example.final_project.controller;
import com.example.final_project.dto.JobDto;
import com.example.final_project.dto.ResponseMessage;
import com.example.final_project.entity.Applicant;
import com.example.final_project.service.imp.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Applicant applicant){
        applicantService.add(applicant);
        return ResponseEntity.ok("successfully added applicant");
    }
    @GetMapping
    public List<Applicant> get(){
        return applicantService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Applicant applicant, @PathVariable Long id){
        applicantService.updateApplicant(applicant,id);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully updated applicant"));
    }
    @GetMapping("/{id}")
    public Applicant getById(@PathVariable Long id){
        return applicantService.findById(id);
    }
    @GetMapping("/job/{id}")
    public List<JobDto> getByJobId(@PathVariable Long id){
        return applicantService.getAllJobsByApplicant(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        applicantService.deleteApplicant(id);
        return ResponseEntity.ok(new ResponseMessage(true,"removed correctly"));
    }

}
