package com.waa.project.controller;

import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.responseDto.CustomResponseDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @LogMe
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<CustomResponseDto<List<UsersDto>>> getAllUsers() {
        List<UsersDto> users = userService.getUsers();
        if(users.isEmpty()) {
            CustomResponseDto<List<UsersDto>> response = new CustomResponseDto<>("204","No Data",null);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } else {
            CustomResponseDto<List<UsersDto>> response = new CustomResponseDto<>("200","Found Data",users);
            return ResponseEntity.ok().body(response);
        }
    }
}
