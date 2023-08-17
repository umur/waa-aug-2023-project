package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.JobAdvertisementRepository;
import com.waa.project.repository.specifications.JobAdvertisementSpecification;
import com.waa.project.service.JobAdvertisementService;
import com.waa.project.util.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }

    @Override
    public JobAdvertisement findById(long id) {
        return jobAdvertisementRepository.findById(id).orElse(null);
    }

    @Override
    public JobPostingDto save(JobPostingDto jobPostingDto, Long id, UserRole userRole) {
        User user = new User();
        JobAdvertisement jobAdvertisement = new JobAdvertisement();
        jobAdvertisement.setTitle(jobPostingDto.getTitle());
        jobAdvertisement.setDescription(jobPostingDto.getDescription());
        jobAdvertisement.setState(jobPostingDto.getState());
        jobAdvertisement.setCity(jobPostingDto.getCity());
        jobAdvertisement.setCompanyName(jobPostingDto.getCompanyName());
        if (user != null) {
            user.setId(id);
            user.setUserRole(userRole);
            jobAdvertisement.setStudent(user);
        } else {
            throw new RuntimeException("error");
        }
        jobAdvertisementRepository.save(jobAdvertisement);
        return getJobById(id);
    }

    @Override
    public ResponseEntity<String> updateJobAdvertisement(JobPostingDto jobPostingDto, Long id, UserRole userRole, String loggedInUserEmail) {
        User user = new User();
        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(id).orElse(null);
        if (existingJobAdvertisement == null) {
            return ResponseEntity.notFound().build();
        }

        // Ensure that only the "Alumni" user who owns the job advertisement can edit it
        if (!loggedInUserEmail.equals(existingJobAdvertisement.getStudent().getEmail())) {
            LoggingUtil.logMessage("log email: " + existingJobAdvertisement.getStudent().getEmail());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to edit this job advertisement.");
        }

        JobAdvertisement jobAdvertisement = new JobAdvertisement();
        jobAdvertisement.setTitle(jobPostingDto.getTitle());
        jobAdvertisement.setDescription(jobPostingDto.getDescription());
        jobAdvertisement.setState(jobPostingDto.getState());
        jobAdvertisement.setCity(jobPostingDto.getCity());
        jobAdvertisement.setCompanyName(jobPostingDto.getCompanyName());
        if (user != null) {
            user.setId(id);
            user.setUserRole(userRole);
            jobAdvertisement.setStudent(user);
        } else {
            throw new RuntimeException("error");
        }

        JobAdvertisement updatedJobAdvertisement = jobAdvertisementRepository.save(existingJobAdvertisement);
        return ResponseEntity.ok("Job advertisement updated successfully.");
    }

    private JobPostingDto getJobById(Long jobId) {
        Optional<JobAdvertisement> optionalJob = jobAdvertisementRepository.findById(jobId);
        if (optionalJob.isPresent()) {
            return JobPostingDto.fromJobAdvertissement(optionalJob.get());
        } else {
            return null;
        }
    }

    public List<JobPostingDto> getAllJobsByStudentId(Long studentId) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.findAllByStudentId(studentId);
        return jobAdvertisements.stream()
                .map(JobPostingDto::fromJobAdvertissement)
                .collect(Collectors.toList());
    }

    public List<JobPostingDto> filter(String state, String city, String companyName) {
        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementRepository.findAll(new JobAdvertisementSpecification(state, city, companyName));
        return jobAdvertisementList.stream().map(JobPostingDto::fromJobAdvertissement).collect(Collectors.toList());
    }
}
