package com.example.demo.service;

import com.example.demo.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto save(JobDto JobDto);
    public List<JobDto> getAll();
    JobDto getById(int id);
    JobDto update(JobDto JobDto, int id);
    boolean delete(int id);
}
