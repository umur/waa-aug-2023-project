package com.example.demo.repository;

import com.example.demo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

    // Retrieve all events where isDeleted is false
    List<Event> findAllByIsDeletedFalse();

    // Retrieve an event by ID where isDeleted is false
    Event findByIdAndIsDeletedFalse(long eventId);

}
