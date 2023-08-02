package com.example.demo.repository;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends ListCrudRepository<User,Long> {
    List<User> findByEmail(String email);
}
