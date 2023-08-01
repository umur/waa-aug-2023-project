package com.waa.project.controller;

import com.waa.project.dto.requestDto.NewPasswordDto;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/activate/{userId}")
    public ResponseEntity<?> activateUser(@PathVariable Long userId) {
        userService.activeUser(userId);
        return ResponseEntity.ok("User activated successfully");
    }
    @PostMapping("/deactivate/{userId}")
    public ResponseEntity<?> deactivateUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.ok("User deactivated successfully");
    }
    @PostMapping("/reset-password/{userId}")
    public ResponseEntity<?> resetPassword(@PathVariable Long userId, @RequestBody NewPasswordDto newPasswordDto) {
        userService.resetUserPassword(userId, newPasswordDto);
        return ResponseEntity.ok("Password reset successfully");
    }
}
