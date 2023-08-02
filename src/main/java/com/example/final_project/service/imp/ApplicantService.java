package com.example.final_project.service.imp;

import com.example.final_project.dto.JobDto;
import com.example.final_project.entity.Applicant;
import com.example.final_project.repository.JobRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.service.IApplicantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.final_project.repository.ApplicantRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicantService implements IApplicantService {
    @Autowired
    private ApplicantRepo applicantRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void add(Applicant applicant) {
        var applicantP = userRepo.findById(applicant.getApplicant().getId()).get();
        var jobP = jobRepo.findById(applicant.getJob().getId()).get();
        applicant.setApplicant(applicantP);
        applicant.setJob(jobP);
        applicantRepo.save(applicant);
    }

    @Override
    public List<Applicant> findAll() {
        return applicantRepo.findAllPresent();
    }

    @Override
    public Applicant findById(Long id) {
        return applicantRepo.findPresentById(id).get();
    }

    @Override
    public void updateApplicant(Applicant applicant, Long id) {
        if(applicantRepo.findPresentById(id).isPresent()){
            var applicantVal = applicantRepo.findPresentById(id).get();
            applicantVal.setJob(applicant.getJob());
            applicantRepo.save(applicantVal);
        }
    }

    @Override
    public void deleteApplicant(Long id) {
        if(applicantRepo.findPresentById(id).isPresent()){
            var applicant = applicantRepo.findPresentById(id).get();
            applicant.setDeleted(false);
            applicantRepo.save(applicant);
        }
        else {
            throw new RuntimeException("Applicant not found");
        }
    }

    @Override
    public List<JobDto> getAllJobsByApplicant(Long id) {
        var jobs = applicantRepo.findAllPresentByJobId(id);
        var jobsDto = new ArrayList<JobDto>();
        jobs.forEach(add->{
            var data = modelMapper.map(add,JobDto.class);
            jobsDto.add(data);
        });
        return jobsDto;
    }
}
