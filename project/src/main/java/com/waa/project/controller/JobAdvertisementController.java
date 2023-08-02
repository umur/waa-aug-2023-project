package com.waa.project.controller;

import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobAdvertisementController {

    private final AuthenticationService authenticationService;
    private final JobAdvertisementService jobAdvertisementService;


    @Autowired
    public JobAdvertisementController(AuthenticationService authenticationService, JobAdvertisementService jobAdvertisementService) {
        this.authenticationService = authenticationService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping
    public ResponseEntity<JobAdvertisement> createJobAdvertisement(@RequestBody JobPostingDto jobPostingDto) {
        Long id = authenticationService.getCurrentUserId();
        UserRole role = authenticationService.getCurrentRole();
        JobAdvertisement createdJobAdvertisement = jobAdvertisementService.save(jobPostingDto, id, role);
        if (createdJobAdvertisement != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdJobAdvertisement);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PreAuthorize("hasRole('ALUMNI') and #jobAdvertisement.student.email == authentication.principal.username")
    @PutMapping
    public ResponseEntity<String> updateJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return jobAdvertisementService.updateJobAdvertisement(jobAdvertisement, loggedInUserEmail);
    }


}
