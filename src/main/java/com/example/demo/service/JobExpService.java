package com.example.demo.service;

import com.example.demo.dto.JobExpDto;


import java.util.List;

public interface JobExpService {
    JobExpDto createJobExperience(JobExpDto jobExpDto);

    JobExpDto updateJobExperience(Integer jobExperienceId, JobExpDto jobExpDto);

    void deleteJobExperience(Integer jobExperienceId);

    List<JobExpDto> getAllJobExperiences();

    JobExpDto getJobExperienceById(Integer jobExperienceId);
}
