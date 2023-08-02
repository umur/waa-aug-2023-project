package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Admin;
import org.springers.waa_alumniplatform.entity.News;
import org.springers.waa_alumniplatform.service.AdminService;
import org.springers.waa_alumniplatform.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    private final NewsService newsService;

    @PutMapping("/{admin_id}/news/{news_id}")
    public ResponseEntity<News> updateNews(@RequestBody News news, @PathVariable int news_id)
    {
        return ResponseEntity.ok(newsService.updateOne(news, news_id));
    }

    @PostMapping("/{admin_id}/news")
    public ResponseEntity<News> addNews(@RequestBody News news, @PathVariable int admin_id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newsService.persist(news, admin_id));
    }

    @GetMapping("/{admin_id}")
    public ResponseEntity<Admin> getOne(@PathVariable int admin_id){
        return ResponseEntity.ok(adminService.getById(admin_id));
    }
    @PostMapping
    public ResponseEntity<Token> createUser(@RequestBody NewUser newUser){
        System.out.println("register controller " + newUser.getPassword());
        Token token =  adminService.createUser(newUser);
        return ResponseEntity
                .status(HttpStatus
                        .CREATED).body(token);
    }

}
