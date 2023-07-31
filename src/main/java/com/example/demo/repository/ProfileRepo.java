package com.example.demo.repository;

import com.example.demo.entity.Profile;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends ListCrudRepository<Profile,Integer> {
}
