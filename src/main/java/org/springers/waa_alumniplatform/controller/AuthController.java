package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.authDto.LoginCredential;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping(path = "/register")
    public ResponseEntity<Token> register(@RequestBody NewUser newUser){
        System.out.println("register controller " + newUser.getPassword());
       Token token =  authService.register(newUser);
       return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginCredential loginCredential){
        Token token = authService.authenticate(loginCredential);
        return ResponseEntity.ok(token);
    }
}
