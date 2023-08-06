package com.example.final_project.repository;

import com.example.final_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String username);
    Optional<User> findUserByEmailAndDeletedEquals(String email, boolean deleted);
    List<User> findUserByDeletedIs(boolean deleted);
    Optional<User> findUserByIdAndDeleted(Long id, boolean deleted);
}
