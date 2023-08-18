package com.example.projectmid.Repositories;

import com.example.projectmid.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserById(int id);
    public User findUserByUsername(String username);

}
