package com.example.demo.controller;


import com.example.demo.service.impl.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

