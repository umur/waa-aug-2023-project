package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Integer> {
}
