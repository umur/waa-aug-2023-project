package com.waa.project.service;

import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobAdvertisementService {

    JobAdvertisement findById(long id);
    JobPostingDto save(JobPostingDto jobPostingDto, Long id, UserRole userRole);
    ResponseEntity<String> updateJobAdvertisement(JobPostingDto jobPostingDto,Long id,UserRole userRole,String loggedInUserEmail);
    public List<JobPostingDto> filter(String state, String city, String companyName);

}
