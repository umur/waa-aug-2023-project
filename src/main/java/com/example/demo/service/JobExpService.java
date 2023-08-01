package com.example.demo.service;

import com.example.demo.dto.JobExpDto;


import java.util.List;

public interface JobExpService {
    JobExpDto createJobExperience(long profileId, JobExpDto jobExpDto);

    JobExpDto updateJobExperience(long profileId, long jobExperienceId, JobExpDto jobExpDto) throws IllegalAccessException;

    void deleteJobExperience(long jobExperienceId);

    List<JobExpDto> getAllJobExperiences();

    JobExpDto getJobExperienceById(long jobExperienceId);
}
