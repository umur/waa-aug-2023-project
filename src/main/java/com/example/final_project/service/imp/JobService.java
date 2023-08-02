package com.example.final_project.service.imp;

import com.example.final_project.dto.JobDto;
import com.example.final_project.entity.Job;
import com.example.final_project.repository.JobRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.service.IJobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void add(JobDto job) {
        var jobVal = modelMapper.map(job, Job.class);
        jobRepo.save(jobVal);
    }

    @Override
    public List<JobDto> findAll() {
       var jobs = jobRepo.findAllPresent();
       var jobsDto = new ArrayList<JobDto>();
       jobs.forEach(add->{
           var data = modelMapper.map(add,JobDto.class);
           jobsDto.add(data);
       });
       return jobsDto;
    }

    @Override
    public JobDto findById(Long id) {
        var job = jobRepo.findPresentById(id).get();
        return modelMapper.map(job, JobDto.class);
    }

    @Override
    public void updateJob(JobDto job, Long id) {
        if(jobRepo.findPresentById(id).isPresent()) {
            var jobVal = modelMapper.map(job, Job.class);
            jobVal.setId(id);
            jobRepo.save(jobVal);
        }
        else{
            throw new RuntimeException("Job not found");
        }
    }

    @Override
    public void deleteJob(Long id) {
        if(jobRepo.findPresentById(id).isPresent()){
            var job = jobRepo.findPresentById(id).get();
            job.setDeleted(true);
            jobRepo.save(job);
        }
        else{
            throw new RuntimeException("Job not found");
        }
    }

    @Override
    public List<JobDto> findJobByÙser(Long id) {
        var job = jobRepo.findAllPresentByJobPosterId(id);
        var jobDto = new ArrayList<JobDto>();
        job.forEach(add->{
            var data = modelMapper.map(add,JobDto.class);
            jobDto.add(data);
        });
        return jobDto;
    }
}
