package com.waa.project.controller;

import com.waa.project.aspect.annotation.CheckUserActive;
import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.dto.responseDto.CustomResponseDto;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;
import com.waa.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @LogMe
    @CheckUserActive
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
    @LogMe
    @CheckUserActive
    @PostMapping("/{id}")
    public UsersDto saveProfileToUser(@PathVariable Long id,@RequestBody UpdatedProfileDto updatedProfileDto) {
        return userService.addProfileToUser(id,updatedProfileDto);
    }
}
