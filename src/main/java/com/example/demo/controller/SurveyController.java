package com.example.demo.controller;

import com.example.demo.dto.SurveyDto;
import com.example.demo.entity.Survey;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyRepo;
import com.example.demo.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surveys")
public class SurveyController {
    @Autowired
    private ISurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAll(){
        try{
            return ResponseEntity.ok(surveyService.getAll());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{surveyId}")
    public ResponseEntity<SurveyDto> getById(@PathVariable int surveyId) {
        try{
            return ResponseEntity.ok(surveyService.getById(surveyId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping("/user/{userId}")
    public ResponseEntity<SurveyDto> save(@PathVariable int userId, @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.save(userId,surveyDto));
    }
    @PutMapping("/{surveyId}/user/{userId}")
    public ResponseEntity<SurveyDto> update(@PathVariable int userId,@PathVariable int surveyId,@RequestBody SurveyDto surveyDto){
        try{
            return ResponseEntity.ok(surveyService.update(userId, surveyId, surveyDto));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("{surveyId}/user/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable int userId,@PathVariable int surveyId){
        /*
         * delete should be enabled for admin
         * */
        try{
            return ResponseEntity.ok(surveyService.delete(userId,surveyId));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

}
