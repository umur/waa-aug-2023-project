package com.waa.project.service;

import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import org.springframework.http.ResponseEntity;

public interface JobAdvertisementService {

    JobAdvertisement findById(long id);
    JobAdvertisement save(JobPostingDto jobPostingDto, Long id, UserRole userRole);
    ResponseEntity<String> updateJobAdvertisement(JobAdvertisement jobAdvertisement, String loggedInUserEmail);
}
