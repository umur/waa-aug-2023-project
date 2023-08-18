package com.example.springproject.service;

import com.example.springproject.entity.User;
import com.example.springproject.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Qualifier("uss")
@Component
@RequiredArgsConstructor
@Transactional
public class UserService {


    private final UserRepo usRepo;



    public User addUser(User u) {
        return usRepo.save(u);
    }

    public List<User> getAllUsers() {
        return usRepo.findAll();
    }

    public Optional<User> getUser(Long id) {
        return usRepo.findById(id);
    }

    public List<User> getUsersWhereIdHas(Long id) {
        return usRepo.findByIdContainingAndIsDeleted(id, false);
    }

    public List<User> getUsersByCity(String city) {
        return usRepo.findByCityAndIsDeleted(city, false);
    }

    public List<User> getUsersByState(String state) {
        return usRepo.findByStateAndIsDeleted(state, false);
    }

    /////////////////////////////////
    public List<User> getUsersWhereNameHas(String name) {
        return usRepo.findByNameContainingAndIsDeleted(name, false);
    }

    public List<User> getStudentByMajor(String major) {
        return usRepo.findByMajorAndIsDeleted(major, false);
    }

    public void deleteUser(Long id) {
        usRepo.updateUserByIdIs(id);
    }
//////////////////////////////////


}
