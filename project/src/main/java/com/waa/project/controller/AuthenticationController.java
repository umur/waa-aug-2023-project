package com.waa.project.controller;

import com.waa.project.dto.requestDto.LoginRequestDto;
import com.waa.project.dto.responseDto.LoginResponseDto;
import com.waa.project.dto.responseDto.RegistrationDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.service.impl.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }
    @PostMapping("/register/student")
    public ResponseEntity<?> registerStudent(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.registerStudent(registrationDto);
    }
}
