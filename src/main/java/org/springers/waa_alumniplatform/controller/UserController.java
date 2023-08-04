package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {
    private final UserService userService;
    @DeleteMapping("/{user_Id}")
    public ResponseEntity<User> deleteUser(@PathVariable int user_Id, Principal principal){
        return ResponseEntity.ok(userService.deleteUser(principal, user_Id));
    }
}
