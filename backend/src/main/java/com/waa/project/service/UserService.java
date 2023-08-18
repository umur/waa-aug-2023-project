package com.waa.project.service;

import com.waa.project.dto.requestDto.NewPasswordDto;
import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;

import java.util.List;

public interface UserService {
    List<UsersDto> getUsers();
    User findByEmail(String userEmail);
    void saveUserProfile(UserProfile updatedProfile);
    void createUser(User newUser);
    void activeUser(Long userId);
    void deactivateUser(Long userId);
    void resetUserPassword(Long userId, NewPasswordDto newPasswordDto);
    UsersDto addProfileToUser(Long userId, UpdatedProfileDto updatedProfileDto);
}
