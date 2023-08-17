package com.example.springproject.repository;


import com.example.springproject.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Long> {


    Optional<User> findByEmail(String email);
    List<User> findByStateAndIsDeleted(String stateName, boolean d);
    List<User> findByCityAndIsDeleted(String cityName, boolean d);
    List<User> findByMajorAndIsDeleted(String major, boolean d);
    List<User> findByNameContainingAndIsDeleted(String name, boolean d);
    List<User> findByIdContainingAndIsDeleted(Long id, boolean d);

    List<User> findAllByIsDeleted(boolean d);

    @Modifying
    @Query(value = "UPDATE `waa-final-project`.`user` SET `is_deleted` = true WHERE (`id` = ?);\n",
            nativeQuery = true)
    void updateUserByIdIs(Long id);
}