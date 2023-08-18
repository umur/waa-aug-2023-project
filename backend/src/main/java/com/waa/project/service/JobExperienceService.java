package com.waa.project.service;

import com.waa.project.dto.requestDto.ExperienceDto;
import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobExperienceService {
    List<JobExperience> getAllJobExperiences();
    JobExperience createJobExperience(JobExperience jobExperience);
    JobExperience getJobExperiences(Long id);
    public ResponseEntity<String> updateJobExperience(ExperienceDto experienceDto, Long id, String loggedInUserEmail);
}
