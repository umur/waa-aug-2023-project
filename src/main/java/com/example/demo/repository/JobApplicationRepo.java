package com.example.demo.repository;

import com.example.demo.entity.JobApplication;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepo extends ListCrudRepository<JobApplication, Long> {
}
