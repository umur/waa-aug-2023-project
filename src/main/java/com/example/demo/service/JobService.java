package com.example.demo.service;

import com.example.demo.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto save(JobDto JobDto);
    public List<JobDto> getAll();
    JobDto getById(long id);
    JobDto update(JobDto JobDto, long id);
    boolean delete(long id);
}
