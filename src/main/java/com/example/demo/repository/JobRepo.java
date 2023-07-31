package com.example.demo.repository;

import com.example.demo.entity.Job;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends ListCrudRepository<Job,Long> {
}
