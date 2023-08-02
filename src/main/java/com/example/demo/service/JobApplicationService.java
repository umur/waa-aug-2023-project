package com.example.demo.service;

import com.example.demo.dto.JobApplicationDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobApplicationService {
    JobApplicationDto save(JobApplicationDto JobApplicationDto);
    List<JobApplicationDto> getAll();
    JobApplicationDto getById(long id);
    JobApplicationDto update(JobApplicationDto JobApplicationDto, long id);
    boolean delete(long id);
}
