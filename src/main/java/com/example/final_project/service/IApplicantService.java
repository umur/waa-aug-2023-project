package com.example.final_project.service;

import com.example.final_project.dto.JobDto;
import com.example.final_project.entity.Address;
import com.example.final_project.entity.Applicant;

import java.util.List;

public interface IApplicantService {
    void add(Applicant applicant);
    List<Applicant> findAll();
    Applicant findById(Long id);
    void updateApplicant(Applicant applicant, Long id);
    void deleteApplicant(Long id);

    List<JobDto> getAllJobsByApplicant(Long id);
}
