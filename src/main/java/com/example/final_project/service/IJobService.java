package com.example.final_project.service;

import com.example.final_project.dto.JobDto;

import java.util.List;

public interface IJobService {
    void add(JobDto job);
    List<JobDto> findAll();
    JobDto findById(Long id);
    void updateJob(JobDto job, Long id);
    void deleteJob(Long id);
    List<JobDto> findJobByÙser(Long id);
}
