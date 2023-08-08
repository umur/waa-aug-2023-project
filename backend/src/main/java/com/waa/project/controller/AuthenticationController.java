package com.waa.project.controller;

import com.waa.project.dto.requestDto.LoginRequestDto;
import com.waa.project.dto.responseDto.RegistrationDto;
import com.waa.project.service.impl.AuthenticationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;
    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.registerStudent(registrationDto);
    }
}
