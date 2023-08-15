package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ISurveyAnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("surveys/questions/{questionId}/answers")
@Validated
@CrossOrigin
public class SurveyAnswerController {
    @Autowired
    private ISurveyAnswerService surveyAnswerService;

    @GetMapping
    @LogActivity(value = "Get all SurveyAnswers")
    public ResponseEntity<List<SurveyAnswerDto>> getAll(){
        try{
            return ResponseEntity.ok(surveyAnswerService.getAll());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{answerId}")
    @LogActivity(value = "Get SurveyAnswer")
    public ResponseEntity<SurveyAnswerDto> getById(@PathVariable long answerId) {
        try{
            return ResponseEntity.ok(surveyAnswerService.getById(answerId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping("/{userId}")
    @LogActivity(value = "Post SurveyAnswer")
    public ResponseEntity<SurveyAnswerDto> save(@Valid @PathVariable long userId, @PathVariable long questionId, @RequestBody SurveyAnswerDto surveyAnswerDto){
        try{
            return ResponseEntity.ok(surveyAnswerService.save(userId, questionId,surveyAnswerDto));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }

    }
    @PutMapping("/{answerId}")
    @LogActivity(value = "Update SurveyAnswer")
    public ResponseEntity<SurveyAnswerDto> update(@Valid @PathVariable long answerId, @RequestBody SurveyAnswerDto surveyAnswerDto){
        try{
            return ResponseEntity.ok(surveyAnswerService.update(answerId, surveyAnswerDto));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{answerId}")
    @LogActivity(value = "Delete SurveyAnswer")
    public ResponseEntity<Boolean> delete(@PathVariable long answerId){
        try{
            return ResponseEntity.ok(surveyAnswerService.delete(answerId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }
}
