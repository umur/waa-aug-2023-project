package com.waa.project.controller;

import com.waa.project.aspect.annotation.CheckUserActive;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.requestDto.ApiResponse;
import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.dto.responseDto.CustomResponseDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.JobAdvertisementService;
import com.waa.project.util.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobAdvertisements")
public class JobAdvertisementController {

    private final AuthenticationService authenticationService;
    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(AuthenticationService authenticationService, JobAdvertisementService jobAdvertisementService) {
        this.authenticationService = authenticationService;
        this.jobAdvertisementService = jobAdvertisementService;
    }
    @LogMe
    @CheckUserActive
    @PostMapping
    public ResponseEntity<JobPostingDto> createJobAdvertisement(@RequestBody JobPostingDto jobPostingDto) {
        Long id = authenticationService.getCurrentUserId();
        UserRole role = authenticationService.getCurrentRole();
        JobPostingDto createdJobAdvertisement = jobAdvertisementService.save(jobPostingDto, id, role);
        if (createdJobAdvertisement != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdJobAdvertisement);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @LogMe
    @CheckUserActive
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateJobAdvertisement(@RequestBody JobPostingDto jobPostingDto, @PathVariable Long id) {
        UserRole role = authenticationService.getCurrentRole();
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        String updatejobAdvertisement = String.valueOf(jobAdvertisementService.updateJobAdvertisement(jobPostingDto, id, role, loggedInUserEmail));

        if (updatejobAdvertisement != null) {
            ApiResponse<String> response = new ApiResponse<>(HttpStatus.CREATED.value(), "Job advertisement updated successfully.", updatejobAdvertisement);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            ApiResponse<String> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to update job advertisement.", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @LogMe
    @CheckUserActive
    @GetMapping
    public List<JobPostingDto> filter(@RequestParam(required = false) String state, @RequestParam(required = false) String city, @RequestParam(required = false) String companyName){
        return jobAdvertisementService.filter(state,city,companyName);
    }
    @LogMe
    @CheckUserActive
    @GetMapping("/findByStudentId/{id}")
    public List<JobPostingDto> getJobById(@PathVariable Long id) {
        return jobAdvertisementService.getAllJobsByStudentId(id);
    }
    @LogMe
    @CheckUserActive
    @GetMapping("/{id}")
    public JobAdvertisement getById(@PathVariable Long id) {
        return jobAdvertisementService.findById(id);
    }
}
