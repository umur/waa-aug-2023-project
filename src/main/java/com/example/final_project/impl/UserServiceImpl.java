package com.example.final_project.impl;

import com.example.final_project.dto.*;
import com.example.final_project.entity.User;
import com.example.final_project.entity.UserLoginAttempt;
import com.example.final_project.enums.Role;
import com.example.final_project.exception.AccountLockedException;
import com.example.final_project.exception.InvalidCredentialsException;
import com.example.final_project.exception.UserNotFoundException;
import com.example.final_project.repository.UserLoginAttemptRepository;
import com.example.final_project.repository.UserRepository;
import com.example.final_project.security.CustomUserDetails;
import com.example.final_project.security.JwtUtil;
import com.example.final_project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//mport org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserLoginAttemptRepository userLoginAttemptRepository;

    @Value("${login.maxAttempts}")
    private int maxLoginAttempts;

    @Value("${login.lockoutDurationMinutes}")
    private int lockoutDurationMinutes;


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = modelMapper.map(registerRequest, User.class);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        CustomUserDetails userDetails = new CustomUserDetails(user);
        var jwtToken = jwtUtil.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        UserLoginAttempt loginAttempt = userLoginAttemptRepository.findUserLoginAttemptByEmail(email).
                orElse(new UserLoginAttempt());

        if (loginAttempt.getAttempts() >= maxLoginAttempts) {
            if (loginAttempt.getLastAttempt().plusMinutes(lockoutDurationMinutes).isAfter(LocalDateTime.now())) {
                throw new AccountLockedException("Account is locked. Try again later.");
            } else {
                // Reset login attempts and last attempt timestamp if the lockout duration has passed
                loginAttempt.setAttempts(0);
                loginAttempt.setLastAttempt(LocalDateTime.now());
            }
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    email,
                    loginRequest.getPassword()));

            // Successful login, reset login attempts
            loginAttempt.setAttempts(0);
            loginAttempt.setLastAttempt(LocalDateTime.now());
            loginAttempt.setEmail(email);
            userLoginAttemptRepository.save(loginAttempt);

            User user = userRepository.findUserByEmail(email).orElseThrow(() ->
                    new RuntimeException("User not found"));
            CustomUserDetails userDetails = new CustomUserDetails(user);
            var jwtToken = jwtUtil.generateToken(userDetails);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        } catch (BadCredentialsException ex) {
            loginAttempt.setAttempts(loginAttempt.getAttempts() + 1);
            loginAttempt.setLastAttempt(LocalDateTime.now());
            loginAttempt.setEmail(email);
            userLoginAttemptRepository.save(loginAttempt);

            throw new InvalidCredentialsException("Invalid username or password");
        } catch (LockedException ex) {
            throw new AccountLockedException("Account is locked. Try again later.");
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Authentication error: " + ex.getMessage(), ex);
        }
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("user not found"));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        if (user.getProfile() != null) {
            ProfileDto profileDto = modelMapper.map(user.getProfile(), ProfileDto.class);
            userDto.setProfileDto(profileDto);
        }

        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findUserByDeletedIs(false);
        List<UserDto> userDtoList = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            if (user.getProfile() != null) {
                ProfileDto profileDto = modelMapper.map(user.getProfile(), ProfileDto.class);
                userDto.setProfileDto(profileDto);
            }
            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    @Override
    public void update(UserUpdate userUpdate, HttpServletRequest httpServletRequest) {
        String email = (String) httpServletRequest.getAttribute("claims");
        User user = userRepository.findUserByEmail(email).get();
        System.out.println("***user****");
        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        user.setPhoneNumber(userUpdate.getPhoneNumber());
        userRepository.save(user);

    }

    @Override
    public void changePassword(PasswordChangeDto pwdDto, HttpServletRequest request) {
        String email = (String) request.getAttribute("claims");
        User user = userRepository.findUserByEmail(email).get();
        if (pwdDto.getPassword().equals(pwdDto.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(pwdDto.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Invalid Password");
        }
    }

    @Override
    public void deActivate(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("user not found")
        );
        if (user.isDeleted() == false) {
            user.setDeleted(true);
        }
        user.setDeleted(false);
    }
}
