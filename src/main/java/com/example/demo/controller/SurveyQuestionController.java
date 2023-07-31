package com.example.demo.controller;

import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ISurveyQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/surveyQuestion")
public class SurveyQuestionController {
    @Autowired
    private ISurveyQuestionService surveyQuestionService;

    @GetMapping
    public ResponseEntity<List<SurveyQuestionDto>> getAll(){
        try{
            return ResponseEntity.ok(surveyQuestionService.getAll());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{surveyQuestionId}")
    public ResponseEntity<SurveyQuestionDto> getById(@PathVariable int surveyQuestionId) {
        try{
            return ResponseEntity.ok(surveyQuestionService.getById(surveyQuestionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping("/user/{userId}")
    public ResponseEntity<SurveyQuestionDto> save(@PathVariable int userId, @RequestBody SurveyQuestionDto surveyQuestionDto){
        return ResponseEntity.ok(surveyQuestionService.save(userId,surveyQuestionDto));
    }
    @PutMapping("/{surveyQuestionId}/user/{userId}")
    public ResponseEntity<SurveyQuestionDto> update(@PathVariable int userId,@PathVariable int surveyQuestionId,@RequestBody SurveyQuestionDto surveyQuestionDto){
        try{
            return ResponseEntity.ok(surveyQuestionService.update(userId, surveyQuestionId, surveyQuestionDto));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("{surveyQuestionId}/user/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable int userId,@PathVariable int surveyQuestionId){
        /*
        * delete should be enabled for admin
        * */
        try{
            return ResponseEntity.ok(surveyQuestionService.delete(userId,surveyQuestionId));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }
}
