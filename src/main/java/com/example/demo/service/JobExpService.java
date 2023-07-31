package com.example.demo.service;

import com.example.demo.dto.JobExpDto;


import java.util.List;

public interface JobExpService {
    JobExpDto createJobExperience(JobExpDto jobExpDto);

    JobExpDto updateJobExperience(Long jobExperienceId, JobExpDto jobExpDto);

    void deleteJobExperience(Long jobExperienceId);

    List<JobExpDto> getAllJobExperiences();

    JobExpDto getJobExperienceById(Long jobExperienceId);
}
