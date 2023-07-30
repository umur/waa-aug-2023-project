package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        UserDto userDto = userService.getById(id);
        if(userDto != null) ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto){
        userService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

}
