package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.LoginRequestDto;
import com.waa.project.dto.responseDto.LoginResponseDto;
import com.waa.project.dto.responseDto.RegistrationDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.JwtTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    private Map<String, Integer> loginAttempts = new HashMap<>();
    private Map<String, LocalDateTime> lockedUsers = new HashMap<>();

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    public ResponseEntity<?> login(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid email");
        }
        User user = optionalUser.get();
        if (isUserLocked(user)) {
            return ResponseEntity.badRequest().body("Account locked. Please try again later.");
        }
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            int attemptCount = loginAttempts.getOrDefault(email, 0) + 1;
            loginAttempts.put(email, attemptCount);
            if (attemptCount >= user.getLoginAttempt()) {
                lockUser(user);
                return ResponseEntity.badRequest().body("Invalid password. Account locked for 15 minutes.");
            } else {
                return ResponseEntity.badRequest().body("Invalid password");
            }
        }
        loginAttempts.remove(email);
        String token = jwtTokenService.generateToken(user);
        UserRole userRole = user.getUserRole();
        return ResponseEntity.ok(new LoginResponseDto(token, userRole));
    }
    private boolean isUserLocked(User user) {
        LocalDateTime lockedTime = lockedUsers.get(user.getEmail());
        if (lockedTime == null) {
            return false;
        }
        LocalDateTime currentTime = LocalDateTime.now();
        return lockedTime.isAfter(currentTime);
    }
    private void lockUser(User user) {
        LocalDateTime lockEndTime = LocalDateTime.now().plusMinutes(15);
        lockedUsers.put(user.getEmail(), lockEndTime);
    }
    public ResponseEntity<?> registerStudent(RegistrationDto registrationDto) {
        if(userRepository.findByEmail(registrationDto.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already exist");
        }
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        if(registrationDto.getRole().toString().isEmpty()) {
            user.setUserRole(UserRole.ALUMNI);
        }
        user.setUserRole(registrationDto.getRole());
        user.setProfile(registrationDto.getProfile());
        user = userRepository.save(user);
        return ResponseEntity.ok(UsersDto.fromUser(user));
    }
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User currentUser = (User) authentication.getPrincipal();
            return (long) currentUser.getId();
        }
        return null;
    }
    public UserRole getCurrentRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User currentUser = (User) authentication.getPrincipal();
            return currentUser.getUserRole();
        }
        return null;
    }
    public boolean getCurrentActiveStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User currentUser = (User) authentication.getPrincipal();
            return currentUser.isActive();
        }
        return false;
    }
}
