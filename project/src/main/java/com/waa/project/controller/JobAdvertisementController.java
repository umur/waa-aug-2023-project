package com.waa.project.controller;

import com.waa.project.entity.JobAdvertisement;
import com.waa.project.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobAdvertisements")
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PreAuthorize("hasRole('ALUMNI') and #jobAdvertisement.student.email == authentication.principal.username")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobAdvertisement(
            @PathVariable long id,
            @RequestBody JobAdvertisement jobAdvertisement
    ) {
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return jobAdvertisementService.updateJobAdvertisement(jobAdvertisement, loggedInUserEmail);
    }


}
