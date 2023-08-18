package com.example.springproject.repository;

import com.example.springproject.entity.Event;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends ListCrudRepository<Event, Integer> {
}
