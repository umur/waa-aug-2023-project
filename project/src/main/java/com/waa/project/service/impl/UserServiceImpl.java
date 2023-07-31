package com.waa.project.service.impl;

import com.waa.project.aspect.annotation.ExecutionTime;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.repository.UserProfileRepository;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @ExecutionTime
    @LogMe
    @Override
    public List<UsersDto> getUsers() {
        var entityList =  userRepository.findAll();
        List<UsersDto> dtoList = new ArrayList<>();
        UsersDto usersDto = new UsersDto();
        entityList.forEach(entity -> {
            usersDto.setId(entity.getId());
            usersDto.setEmail(entity.getEmail());
            usersDto.setPassword(entity.getPassword());
            usersDto.setUserRole(entity.getUserRole());
            usersDto.setPassword(entity.getPassword());
            usersDto.setLastLogin(entity.getLastLogin());
            usersDto.setProfile(entity.getProfile());
            usersDto.setLoginAttempt(entity.getLoginAttempt());
            usersDto.setActive(entity.isActive());
            dtoList.add(usersDto);
        });
        return dtoList;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public void saveUserProfile(UserProfile userProfile) {
        // Assuming you have a separate repository for the UserProfile entity
        // If UserProfile and User are in the same repository, you can use userRepository.save(userProfile) directly
        userProfileRepository.save(userProfile);
    }
    @Override
    public void createUser(User newUser) {
        userRepository.save(newUser);
    }
}
