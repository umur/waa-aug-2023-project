package com.example.demo.repository;

import com.example.demo.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplication, Long> {
}
