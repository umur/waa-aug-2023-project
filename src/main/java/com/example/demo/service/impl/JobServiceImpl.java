package com.example.demo.service.impl;

import com.example.demo.dto.JobDto;
import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.repository.JobRepo;
import com.example.demo.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepo jobRepo;
    private final ModelMapper modelMapper;
    @Override
    public JobDto save(JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        Job newJob = jobRepo.save(job);
        return modelMapper.map(newJob, JobDto.class);
    }

    @Override
    public List<JobDto> getAll() {
        List<Job> jobList = jobRepo.findAll();
        return jobList.stream().map(job ->
                modelMapper.map(job, JobDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobDto getById(long id) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if(jobOptional.isEmpty()){
            return null;
        }
        Job job = jobOptional.get();
        return modelMapper.map(job, JobDto.class);
    }

    @Override
    public JobDto update(JobDto jobDto, long id) {
        if(!jobRepo.existsById(id)){
            return null;
        }
        JobDto entityDto = getById(id);
        Job job = modelMapper.map(entityDto, Job.class);
        if(jobDto.getCompanyName() != null) job.setCompanyName(jobDto.getCompanyName());
        if(jobDto.getCity() != null) job.setCity(jobDto.getCity());
        if(jobDto.getState() != null) job.setState(jobDto.getState());
        if(jobDto.getDescription() != null) job.setDescription(jobDto.getDescription());
        if(jobDto.getTitle() != null) job.setTitle(jobDto.getTitle());
        Job updatedJob = jobRepo.save(job);
        return modelMapper.map(updatedJob, JobDto.class);
    }

    @Override
    public boolean delete(long id) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if(jobOptional.isEmpty()){
            return false;
        }
        Job job = jobOptional.get();
        job.setDeleted(true);
        jobRepo.save(job);
        return true;
    }
}
