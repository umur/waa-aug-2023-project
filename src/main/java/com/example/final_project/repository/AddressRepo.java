package com.example.final_project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import com.example.final_project.entity.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepo extends ListCrudRepository<Address,Long> {
    @Query("SELECT e FROM Address e WHERE e.deleted = false")
    List<Address> findAllPresent();

    @Query("SELECT e FROM Address e WHERE e.deleted = false AND e.id = ?1")
    Optional<Address> findPresentById(Long id);
}
