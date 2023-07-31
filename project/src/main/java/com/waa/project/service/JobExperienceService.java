package com.waa.project.service;

import com.waa.project.entity.JobExperience;

import java.util.List;

public interface JobExperienceService {
    List<JobExperience> getAllJobExperiences();
    JobExperience createJobExperience(JobExperience jobExperience);
}
