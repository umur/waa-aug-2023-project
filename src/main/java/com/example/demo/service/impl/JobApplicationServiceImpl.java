package com.example.demo.service.impl;

import com.example.demo.dto.JobApplicationDto;

import com.example.demo.entity.JobApplication;
import com.example.demo.repository.JobApplicationRepo;
import com.example.demo.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationRepo jobApplicationRepo;
    private final ModelMapper modelMapper;
    @Override
    public JobApplicationDto save(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication = modelMapper.map(jobApplicationDto, JobApplication.class);
        JobApplication newJobApplication = jobApplicationRepo.save(jobApplication);
        return modelMapper.map(newJobApplication, JobApplicationDto.class);
    }

    @Override
    public List<JobApplicationDto> getAll() {
        List<JobApplication> jobApplicationList = jobApplicationRepo.findAll();
        return jobApplicationList.stream().map(jobApplication ->
                modelMapper.map(jobApplication, JobApplicationDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobApplicationDto getById(long id) {
        Optional<JobApplication> jobApplicationOptional = jobApplicationRepo.findById(id);
        if(jobApplicationOptional.isEmpty()){
            return null;
        }
        JobApplication jobApplication = jobApplicationOptional.get();
        return modelMapper.map(jobApplication, JobApplicationDto.class);
    }

    @Override
    public JobApplicationDto update(JobApplicationDto jobApplicationDto, long id) {
        if(!jobApplicationRepo.existsById(id)){
            return null;
        }
        JobApplicationDto entityDto = getById(id);
        JobApplication jobApplication = modelMapper.map(entityDto, JobApplication.class);
        if(jobApplication.getApplicant() != null) jobApplication.setApplicant(jobApplicationDto.getApplicant());
        if(jobApplication.getJob() != null) jobApplication.setJob(jobApplicationDto.getJob());
        if(jobApplication.getApplicationDate() != null) jobApplication.setApplicationDate(jobApplicationDto.getApplicationDate());
        JobApplication updated = jobApplicationRepo.save(jobApplication);
        return modelMapper.map(updated, JobApplicationDto.class);
    }

    @Override
    public boolean delete(long id) {
        Optional<JobApplication> jobApplicationOptional = jobApplicationRepo.findById(id);
        if(jobApplicationOptional.isEmpty()){
            return false;
        }
        JobApplication jobApplication = jobApplicationOptional.get();
        jobApplication.setDeleted(true);
        jobApplicationRepo.save(jobApplication);
        return true;
    }
}
