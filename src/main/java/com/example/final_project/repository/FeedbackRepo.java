package com.example.final_project.repository;

import com.example.final_project.entity.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepo extends ListCrudRepository<Feedback,Long> {
    @Query("SELECT e FROM Address e WHERE e.deleted = false")
    List<Feedback> findAllPresent();

}
