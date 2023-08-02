package com.example.final_project.repository;

import com.example.final_project.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User,Long> {
}
