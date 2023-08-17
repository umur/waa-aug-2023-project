package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.JobPostingDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.JobAdvertisement;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.JobAdvertisementRepository;
import com.waa.project.repository.UserRepository;
import com.waa.project.repository.specifications.JobAdvertisementSpecification;
import com.waa.project.service.JobAdvertisementService;
import com.waa.project.util.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    private final UserRepository userRepository;

    @Autowired
    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository, UserRepository userRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.userRepository = userRepository;
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

        Optional<User> loggedInUser = userRepository.findByEmail(loggedInUserEmail); // Fetch the logged-in user from the repository

        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(id).orElse(null);
        if (existingJobAdvertisement == null) {
            return ResponseEntity.notFound().build();
        }

        // Ensure that only the user who owns the job advertisement can edit it
        if (!loggedInUserEmail.equals(existingJobAdvertisement.getStudent().getEmail())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to edit this job advertisement.");
        }

        existingJobAdvertisement.setTitle(jobPostingDto.getTitle());
        existingJobAdvertisement.setDescription(jobPostingDto.getDescription());
        existingJobAdvertisement.setState(jobPostingDto.getState());
        existingJobAdvertisement.setCity(jobPostingDto.getCity());
        existingJobAdvertisement.setCompanyName(jobPostingDto.getCompanyName());

        // If you have a user associated with the job advertisement, update its role
        if (loggedInUser != null) {
            existingJobAdvertisement.getStudent().setUserRole(userRole);
        } else {
            throw new RuntimeException("Logged-in user not found."); // Handle this exception properly
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
        Specification<JobAdvertisement> specification = Specification.where(null);

        if (state != null && !state.isEmpty()) {
            specification = specification.and(JobAdvertisementSpecification.byState(state));
        }

        if (city != null && !city.isEmpty()) {
            specification = specification.and(JobAdvertisementSpecification.byCity(city));
        }

        if (companyName != null && !companyName.isEmpty()) {
            specification = specification.and(JobAdvertisementSpecification.byCompanyName(companyName));
        }

        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementRepository.findAll(specification);
        return jobAdvertisementList.stream().map(JobPostingDto::fromJobAdvertissement).collect(Collectors.toList());
    }
}
