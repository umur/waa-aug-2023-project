package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.UserAuthenticationRequestDTO;
import com.example.demo.dto.UserAuthenticationResponseDTO;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserAuthenticationService;
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
    @Autowired
    private UserAuthenticationService service;

    @PostMapping
    @LogActivity(value = "Post user")
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = userService.save(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/login")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return  ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping
    @LogActivity(value = "Get users")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    @LogActivity(value = "Get user")

    //TODO Id should be long

    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto userDto = userService.getById(id);
        if(userDto != null) return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @LogActivity(value = "Update user")
    public ResponseEntity<UserDto> update(@Valid @PathVariable Long id, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.update(userDto, id);
        if(updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @LogActivity(value = "Delete user")
    public ResponseEntity delete(@PathVariable Long id){
        boolean deleted = userService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/logout")
    @LogActivity(value = "User loggedOut")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Logout successful");
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthenticationResponseDTO> register(@RequestBody UserAuthenticationRequestDTO userAuthenticationRequestDTO) {
        return ResponseEntity.ok(service.register(userAuthenticationRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponseDTO> authenticate(@RequestBody UserLoginDto userLoginDto) {
        return ResponseEntity.ok(service.authenticate(userLoginDto));
    }


}
