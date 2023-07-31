package com.example.demo.service.impl;

import com.example.demo.dto.JobExpDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.JobExperience;
import com.example.demo.repository.JobExpRepo;
import com.example.demo.service.JobExpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JobExpServiceImpl implements JobExpService {

    @Autowired
    private final JobExpRepo jobExpRepo;
    private final ModelMapper modelMapper;

    @Override
    public JobExpDto createJobExperience(JobExpDto jobExpDto) {
        JobExperience jobExperience = modelMapper.map(jobExpDto, JobExperience.class);
        JobExperience savedJobExperience = jobExpRepo.save(jobExperience);
        return modelMapper.map(savedJobExperience, JobExpDto.class);
    }

    @Override
    public JobExpDto updateJobExperience(Long jobExperienceId, JobExpDto jobExpDto) {
        JobExperience existingJobExperience = jobExpRepo.findById(jobExperienceId).orElse(null);
        if (existingJobExperience == null) {
            return null;
        }

        // Update the properties of the existing job experience
        existingJobExperience.setCompanyName(jobExpDto.getCompanyName());
        existingJobExperience.setPosition(jobExpDto.getPosition());
        existingJobExperience.setStartDate(jobExpDto.getStartDate());
        existingJobExperience.setEndDate(jobExpDto.getEndDate());
        existingJobExperience.setDescription(jobExpDto.getDescription());
//        existingJobExperience.setUserId(jobExpDto.getUserId());

        JobExperience updatedJobExperience = jobExpRepo.save(existingJobExperience);
        return modelMapper.map(updatedJobExperience, JobExpDto.class);
    }

    @Override
    public void deleteJobExperience(Long jobExperienceId) {
        JobExperience existingJobExp = jobExpRepo.findById(jobExperienceId).orElse(null);
        if (existingJobExp == null) {
//            throw new NotFoundException("Event not found with ID: " + eventId);
            return;
        }

        jobExpRepo.delete(existingJobExp);
    }


    @Override
    public List<JobExpDto> getAllJobExperiences() {
        List<JobExperience> jobExperienceList = jobExpRepo.findAll();
        return jobExperienceList.stream()
                .map(jobExperience -> modelMapper.map(jobExperience, JobExpDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobExpDto getJobExperienceById(Long jobExperienceId) {
        JobExperience jobExperience = jobExpRepo.findById(jobExperienceId).orElse(null);
        if (jobExperience == null) {
            return null;
        }
        return modelMapper.map(jobExperience, JobExpDto.class);
    }
}