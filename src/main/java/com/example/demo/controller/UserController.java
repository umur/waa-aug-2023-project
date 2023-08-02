package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@Valid  @RequestBody UserDto userDto){
        UserDto createdUser = userService.save(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/login")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return  ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        UserDto userDto = userService.getById(id);
        if(userDto != null) return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@Valid @PathVariable int id, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.update(userDto, id);
        if(updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean deleted = userService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid  @RequestBody UserLoginDto userLoginDto) {
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();

        //TODO Check for null or empty values, and valid email format

        //TODO Call the UserService to perform authentication
//        boolean isAuthenticated = userService.authenticateUser(email, password);
//
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
        return ResponseEntity.ok("Login successful");
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Logout successful");
    }

}
