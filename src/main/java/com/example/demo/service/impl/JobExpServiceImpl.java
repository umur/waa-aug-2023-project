package com.example.demo.service.impl;

import com.example.demo.dto.JobExpDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.JobExperience;
import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.JobExpRepo;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.service.JobExpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JobExpServiceImpl implements JobExpService {

    @Autowired
    private  JobExpRepo jobExpRepo;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public JobExpDto createJobExperience(long profileId, JobExpDto jobExpDto) {
        Profile profile =profileRepo.findById(profileId).orElse(null);
        if (profile == null) {
            throw new ResourceNotFoundException("Profile not found with ID: " + profileId);
        }
        JobExperience jobExperience = modelMapper.map(jobExpDto, JobExperience.class);
        jobExperience.setProfile(profile);
        JobExperience savedJobExperience = jobExpRepo.save(jobExperience);
        return modelMapper.map(savedJobExperience, JobExpDto.class);
    }

    @Override
    public JobExpDto updateJobExperience(long profileId, long jobExperienceId, JobExpDto jobExpDto) throws IllegalAccessException {
        JobExperience existingJobExperience = jobExpRepo.findById(jobExperienceId).orElse(null);
        if (existingJobExperience == null) {
            return null;
        }
        if (existingJobExperience.getProfile().getId() != profileId) {
            throw new IllegalAccessException("You are not authorized to update this Job Experiance.");
        }
        existingJobExperience.setCompanyName(jobExpDto.getCompanyName());
        existingJobExperience.setPosition(jobExpDto.getPosition());
        existingJobExperience.setStartDate(jobExpDto.getStartDate());
        existingJobExperience.setEndDate(jobExpDto.getEndDate());
        existingJobExperience.setDescription(jobExpDto.getDescription());

        JobExperience updatedJobExperience = jobExpRepo.save(existingJobExperience);
        return modelMapper.map(updatedJobExperience, JobExpDto.class);
    }

    @Override
    public void deleteJobExperience(long jobExperienceId) {
        JobExperience existingJobExp = jobExpRepo.findById(jobExperienceId).orElse(null);
        if (existingJobExp == null) {
            throw new ResourceNotFoundException("Job Experience not found with ID: " + jobExperienceId);
        }

        existingJobExp.setDeleted(true);
        jobExpRepo.save(existingJobExp);
    }


    @Override
    public List<JobExpDto> getAllJobExperiences() {
        List<JobExperience> jobExperienceList = jobExpRepo.findAllByIsDeletedFalse();
        return jobExperienceList.stream()
                .map(jobExperience -> modelMapper.map(jobExperience, JobExpDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobExpDto getJobExperienceById(long jobExperienceId) {
        JobExperience jobExperience = jobExpRepo.findByIdAndIsDeletedFalse(jobExperienceId); // Find by ID and ensure it's not deleted
        if (jobExperience == null) {
            return null;
        }
        return modelMapper.map(jobExperience, JobExpDto.class);
    }
}