package com.example.final_project.repository;

import com.example.final_project.entity.Profile;
import org.springframework.data.repository.ListCrudRepository;

public interface ProfileRepo extends ListCrudRepository<Profile, Long> {
    Profile findProfileByUserId(Long id);
}
