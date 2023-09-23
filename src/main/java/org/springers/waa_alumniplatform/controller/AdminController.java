package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.authDto.Password;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Admin;
import org.springers.waa_alumniplatform.entity.News;
import org.springers.waa_alumniplatform.entity.Survey;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.service.AdminService;
import org.springers.waa_alumniplatform.service.NewsService;
import org.springers.waa_alumniplatform.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    private final NewsService newsService;
    private final SurveyService surveyService;

    @PutMapping("/{admin_id}/news/{news_id}")
    public ResponseEntity<News> updateNews(@RequestBody News news, @PathVariable int news_id)
    {
        return ResponseEntity.ok(newsService.updateOne(news, news_id));
    }
    @PutMapping("/{admin_id}/survey/{survey_id}")
    public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey, @PathVariable int survey_id)
    {
        return ResponseEntity.ok(surveyService.updateOne(survey, survey_id));
    }

    @PatchMapping("/{admin_Id}/users/{user_Id}/activateDeactivate")
    public ResponseEntity<User> activateDeactivateUser(@PathVariable int user_Id){
        return ResponseEntity.ok(adminService.activateDeactivateUser(user_Id));
    }

    @PatchMapping("/{admin_Id}/users/{user_Id}/resetPassword")
    public ResponseEntity<User> resetUserPassword(@RequestBody Password password, @PathVariable int user_Id){
        return ResponseEntity.ok(adminService.resetUserPassword(password, user_Id));
    }

    @PostMapping("/{admin_id}/news")
    public ResponseEntity<News> addNews(@RequestBody News news, @PathVariable int admin_id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newsService.persist(news, admin_id));
    }

    @PostMapping("/{admin_id}/survey")
    public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(surveyService.persist(survey));
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
