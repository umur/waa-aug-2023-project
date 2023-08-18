package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.ExperienceDto;
import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.JobExperienceRepository;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.JobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobExperienceServiceImpl implements JobExperienceService {
    private final JobExperienceRepository jobExperienceRepository;
    private final UserRepository userRepository;
    @Autowired
    public JobExperienceServiceImpl(JobExperienceRepository jobExperienceRepository, UserRepository userRepository) {
        this.jobExperienceRepository = jobExperienceRepository;
        this.userRepository = userRepository;
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
    public ResponseEntity<String> updateJobExperience(ExperienceDto experienceDto, Long id, String loggedInUserEmail) {

        Optional<User> loggedInUser = userRepository.findByEmail(loggedInUserEmail); // Fetch the logged-in user from the repository

        JobExperience existingJobExperience = jobExperienceRepository.findById(id).orElse(null);
        if (existingJobExperience == null) {
            return ResponseEntity.notFound().build();
        }

        existingJobExperience.setCompanyName(experienceDto.getCompanyName());
        existingJobExperience.setPosition(experienceDto.getPosition());

        JobExperience updatedJobAdvertisement = jobExperienceRepository.save(existingJobExperience);
        return ResponseEntity.ok("Job experience updated successfully.");
    }
}
