package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.NewPasswordDto;
import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.UserProfileRepository;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.UserService;
import com.waa.project.util.LoggingUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserProfileRepository userProfileRepository;

    @Override
    public List<UsersDto> getUsers() {
        var entityList =  userRepository.findAll();
        List<UsersDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            UsersDto usersDto = new UsersDto();
            User user = new User();
            user.setProfile(entity.getProfile());
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
        LoggingUtil.logMessage("my entity list: "+dtoList);
        return dtoList;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public void saveUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }
    @Override
    public void createUser(User newUser) {
        userRepository.save(newUser);
    }
    @Override
    public void activeUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.isActive()) {
                user.setActive(true);
                user.isEnabled();
                userRepository.save(user);
            } else {
                throw new UnsupportedOperationException("This user is activation .");
            }
        } else {
            throw new UsernameNotFoundException("User not found with ID: " + userId);
        }
    }
    @Override
    public void deactivateUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getUserRole() != UserRole.ADMIN) {
                user.setActive(false);
                userRepository.save(user);
            } else {
                throw new UnsupportedOperationException("Cannot deactivate an ADMIN user.");
            }
        } else {
            throw new UsernameNotFoundException("User not found with ID: " + userId);
        }
    }
    @Override
    public void resetUserPassword(Long userId, NewPasswordDto newPasswordDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent() && !optionalUser.get().getUserRole().equals(UserRole.ADMIN)) {
            User user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPasswordDto.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }
    }
    @Override
    public UsersDto addProfileToUser(Long userId, UpdatedProfileDto updatedProfileDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User profile not found with ID: " + userId));

        UserProfile userProfile = new UserProfile();
        userProfile.setId(updatedProfileDto.getId());
        userProfile.setFirstName(updatedProfileDto.getFirstName());
        userProfile.setLastName(updatedProfileDto.getLastName());
        userProfile.setProfilePicture(updatedProfileDto.getProfilePicture());
        userProfile.setGender(updatedProfileDto.getGender());

        UserProfile newUserProfile = userProfileRepository.save(userProfile);

        UsersDto usersDto = new UsersDto();
        usersDto.setId(user.getId());
        usersDto.setEmail(user.getEmail());
        usersDto.setActive(user.isActive());
        usersDto.setProfile(newUserProfile);
        usersDto.setUserRole(user.getUserRole());
        usersDto.setLastLogin(user.getLastLogin());
        usersDto.setLoginAttempt(user.getLoginAttempt());

        return usersDto;
    }
}
