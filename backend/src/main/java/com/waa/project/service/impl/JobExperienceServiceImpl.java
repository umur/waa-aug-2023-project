package com.waa.project.service.impl;

import com.waa.project.entity.JobExperience;
import com.waa.project.repository.JobExperienceRepository;
import com.waa.project.service.JobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobExperienceServiceImpl implements JobExperienceService {
    private final JobExperienceRepository jobExperienceRepository;
    @Autowired
    public JobExperienceServiceImpl(JobExperienceRepository jobExperienceRepository) {
        this.jobExperienceRepository = jobExperienceRepository;
    }
    @Override
    public List<JobExperience> getAllJobExperiences() {
        return jobExperienceRepository.findAll();
    }
    @Override
    public JobExperience createJobExperience(JobExperience jobExperience) {
        return jobExperienceRepository.save(jobExperience);
    }
    @Override
    public JobExperience getJobExperiences(Long id) {
        return jobExperienceRepository.findById(id).get();
    }
}
