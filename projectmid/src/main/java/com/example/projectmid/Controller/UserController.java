package com.example.projectmid.Controller;

import com.example.projectmid.Entities.User;
import com.example.projectmid.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user){
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }
}
