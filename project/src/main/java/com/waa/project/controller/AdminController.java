package com.waa.project.controller;

import com.waa.project.dto.requestDto.NewPasswordDto;
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

    @PreAuthorize("hasRole(ADMIN)")
    @PostMapping("/activate/{userId}")
    public ResponseEntity<?> activateUser(@PathVariable Long userId) {
        userService.activeUser(userId);
        return ResponseEntity.ok("User activated successfully");
    }
    @PreAuthorize("hasRole(ADMIN)")
    @PostMapping("/deactivate/{userId}")
    public ResponseEntity<?> deactivateUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.ok("User deactivated successfully");
    }
    @PreAuthorize("hasRole(ADMIN)")
    @PostMapping("/reset-password/{userId}")
    public ResponseEntity<?> resetPassword(@PathVariable Long userId, @RequestBody NewPasswordDto newPasswordDto) {
        userService.resetUserPassword(userId, newPasswordDto);
        return ResponseEntity.ok("Password reset successfully");
    }
}
