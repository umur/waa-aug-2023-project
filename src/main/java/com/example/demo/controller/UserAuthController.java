package com.example.demo.controller;


import com.example.demo.dto.UserAuthenticationRequestDTO;
import com.example.demo.dto.UserAuthenticationResponseDTO;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.service.impl.UserAuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAuthController {
    @Autowired
    private UserAuthenticationService service;
//    @PostMapping("/register")
//    public ResponseEntity<UserAuthenticationResponseDTO> register(@Valid @RequestBody UserAuthenticationRequestDTO userAuthenticationRequestDTO) {
//        return ResponseEntity.ok(service.register(userAuthenticationRequestDTO));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<UserAuthenticationResponseDTO> register(@RequestBody UserLoginDto userLoginDto) {
//        return ResponseEntity.ok(service.authenticate(userLoginDto));
//    }
}

