package com.example.final_project.repository;

import com.example.final_project.entity.Address;
import com.example.final_project.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepo extends ListCrudRepository<Job,Long> {
    @Query("SELECT e FROM Job e WHERE e.deleted = false")
    List<Job> findAllPresent();

    @Query("SELECT e FROM Job e WHERE e.deleted = false AND e.id = ?1")
    Optional<Job> findPresentById(Long id);

    @Query("SELECT e FROM Job e WHERE e.jobPoster.id = ?1 AND e.deleted = false")
    List<Job> findAllPresentByJobPosterId(Long id);
}
