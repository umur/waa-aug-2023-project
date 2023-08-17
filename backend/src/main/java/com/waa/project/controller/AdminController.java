package com.waa.project.controller;

import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.requestDto.NewPasswordDto;
import com.waa.project.dto.requestDto.SystemLogRequestDto;
import com.waa.project.dto.responseDto.CustomResponseDto;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.SystemLogService;
import com.waa.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final SystemLogService systemLogService;
    private final AuthenticationService authenticationService;
    @LogMe
    @PostMapping("/activate/{userId}")
    public ResponseEntity<?> activateUser(@PathVariable Long userId) {
        userService.activeUser(userId);
        return ResponseEntity.ok("User activated successfully");
    }
    @LogMe
    @PostMapping("/deactivate/{userId}")
    public ResponseEntity<?> deactivateUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.ok("User deactivated successfully");
    }
    @LogMe
    @PostMapping("/reset-password/{userId}")
    public ResponseEntity<?> resetPassword(@PathVariable Long userId, @RequestBody NewPasswordDto newPasswordDto) {
        userService.resetUserPassword(userId, newPasswordDto);
        return ResponseEntity.ok("Password reset successfully");
    }
    @LogMe
    @GetMapping("/logs")
    public ResponseEntity<CustomResponseDto<List<SystemLogRequestDto>>> getAllLogs() {
        List<SystemLogRequestDto> logs = systemLogService.getSystemLogs();
        if(logs.isEmpty()) {
            CustomResponseDto<List<SystemLogRequestDto>> response = new CustomResponseDto<>("204","No Data",null);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } else {
            CustomResponseDto<List<SystemLogRequestDto>> response = new CustomResponseDto<>("200","Found Data",logs);
            return ResponseEntity.ok().body(response);
        }
    }
}
