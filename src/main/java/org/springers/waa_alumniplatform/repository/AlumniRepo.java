package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumniRepo extends JpaRepository<Alumni, Integer> {
    Optional<Alumni> findUserById(int alumniId);
}
