package com.waa.project.service;

import com.waa.project.entity.JobAdvertisement;
import org.springframework.http.ResponseEntity;

public interface JobAdvertisementService {

    public JobAdvertisement findById(long id);
    public JobAdvertisement save(JobAdvertisement jobAdvertisement);
    public ResponseEntity<String> updateJobAdvertisement(JobAdvertisement jobAdvertisement, String loggedInUserEmail);
}
