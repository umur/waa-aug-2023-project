package com.waa.project.service;

import com.waa.project.dto.requestDto.LoginRequestDto;
import com.waa.project.dto.responseDto.RegistrationDto;
import com.waa.project.entity.UserRole;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    public Long getCurrentUserId();
    public ResponseEntity<?> registerStudent(RegistrationDto registrationDto);
    public ResponseEntity<?> login(LoginRequestDto loginRequestDto);
    boolean getCurrentActiveStatus();
    UserRole getCurrentRole();
}
