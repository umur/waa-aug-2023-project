package com.example.final_project.repository;

import com.example.final_project.entity.Address;
import com.example.final_project.entity.Applicant;
import com.example.final_project.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepo extends ListCrudRepository<Applicant,Long> {
    @Query("SELECT e FROM Applicant e WHERE e.deleted = false")
    List<Applicant> findAllPresent();

    @Query("SELECT e FROM Applicant e WHERE e.deleted = false AND e.id = ?1")
    Optional<Applicant> findPresentById(Long id);

    @Query("SELECT j FROM Applicant e JOIN e.job j WHERE j.deleted = false AND e.deleted = false AND e.applicant.id = ?1")
    List<Job> findAllPresentByJobId(Long id);
}
