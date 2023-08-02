package com.example.final_project.controller;

import com.example.final_project.dto.*;
import com.example.final_project.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping ("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        AuthenticationResponse response = userService.register(registerRequest);
         return ResponseEntity.ok(response);

    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
       AuthenticationResponse response = userService.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) throws UserPrincipalNotFoundException {
       UserDto userDto = userService.getUser(id);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
       List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok(userDtoList);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserUpdate userUpdate, HttpServletRequest request){
          userService.update(userUpdate, request);
          SuccessResponse successResponse= new SuccessResponse(true, "update successful");
          return ResponseEntity.ok(successResponse);
    }
    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeDto pwdDto, HttpServletRequest request){
        userService.changePassword(pwdDto, request);
        return ResponseEntity.ok(new SuccessResponse(true, "password changed successfully"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deActivate(@PathVariable Long id){
        userService.deActivate(id);
        return ResponseEntity.ok(new SuccessResponse(true, "user deactivated"));
    }


}
