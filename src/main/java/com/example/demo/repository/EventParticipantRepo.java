package com.example.demo.repository;

import com.example.demo.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventParticipantRepo extends JpaRepository<EventParticipant, Long>{

    Optional<EventParticipant> findByUserIdAndEventId(long userId, long eventId);
}
