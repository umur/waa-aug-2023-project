package com.example.final_project.repository;

import com.example.final_project.entity.UserLoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginAttemptRepository extends JpaRepository<UserLoginAttempt, Long> {
    Optional<UserLoginAttempt> findUserLoginAttemptByEmail(String email);
}
