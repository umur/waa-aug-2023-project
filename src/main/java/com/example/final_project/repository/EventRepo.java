package com.example.final_project.repository;

import com.example.final_project.entity.Event;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends ListCrudRepository<Event,Long> {
}
