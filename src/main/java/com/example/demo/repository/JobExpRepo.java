package com.example.demo.repository;

import com.example.demo.entity.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExpRepo extends JpaRepository<JobExperience, Long> {
    // Retrieve all job experiences where isDeleted is false
    List<JobExperience> findAllByIsDeletedFalse();

    // Retrieve job experience by ID where isDeleted is false
    JobExperience findByIdAndIsDeletedFalse(long jobExperienceId);
}