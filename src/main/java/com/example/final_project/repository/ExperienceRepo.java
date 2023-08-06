package com.example.final_project.repository;

import com.example.final_project.entity.Address;
import com.example.final_project.entity.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepo extends ListCrudRepository<Experience,Long> {
    @Query("SELECT e FROM Experience e WHERE e.deleted = false")
    List<Experience> findAllPresent();

    @Query("SELECT e FROM Experience e WHERE e.deleted = false AND e.id = ?1")
    Optional<Experience> findPresentById(Long id);
}
