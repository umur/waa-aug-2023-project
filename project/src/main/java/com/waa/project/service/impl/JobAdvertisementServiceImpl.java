package com.waa.project.service.impl;

import com.waa.project.entity.JobAdvertisement;
import com.waa.project.repository.JobAdvertisementRepository;
import com.waa.project.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }
    @Override
    public JobAdvertisement findById(long id) {
        return jobAdvertisementRepository.findById(id).orElse(null);
    }

    public JobAdvertisement save(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public ResponseEntity<String> updateJobAdvertisement(JobAdvertisement jobAdvertisement, String loggedInUserEmail) {
        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisement.getId()).orElse(null);
        if (existingJobAdvertisement == null) {
            return ResponseEntity.notFound().build();
        }

        // Ensure that only the "Alumni" user who owns the job advertisement can edit it
        if (!loggedInUserEmail.equals(existingJobAdvertisement.getStudent().getEmail())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to edit this job advertisement.");
        }

        existingJobAdvertisement.setTitle(jobAdvertisement.getTitle());
        existingJobAdvertisement.setDescription(jobAdvertisement.getDescription());
        existingJobAdvertisement.setState(jobAdvertisement.getState());
        existingJobAdvertisement.setCity(jobAdvertisement.getCity());
        existingJobAdvertisement.setCompanyName(jobAdvertisement.getCompanyName());

        JobAdvertisement updatedJobAdvertisement = jobAdvertisementRepository.save(existingJobAdvertisement);
        return ResponseEntity.ok("Job advertisement updated successfully.");
    }


}
