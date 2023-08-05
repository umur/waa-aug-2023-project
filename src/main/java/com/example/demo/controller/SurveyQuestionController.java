package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.ChoiceDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ISurveyQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/surveys/{surveyId}/questions")
@Validated
public class SurveyQuestionController {
    @Autowired
    private ISurveyQuestionService surveyQuestionService;

    @GetMapping
    @LogActivity(value = "Get all SurveyQuestions")
    public ResponseEntity<List<SurveyQuestionDto>> getAll(@PathVariable long surveyId){
        try{
            return ResponseEntity.ok(surveyQuestionService.getAll(surveyId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{questionId}")
    @LogActivity(value = "Get SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> getById(@PathVariable long questionId) {
        try{
            return ResponseEntity.ok(surveyQuestionService.getById(questionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping("/{userId}")
    @LogActivity(value = "Post SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> save(@Valid @PathVariable long userId,@PathVariable long surveyId, @RequestBody SurveyQuestionDto surveyQuestionDto){
        return ResponseEntity.ok(surveyQuestionService.save(userId,surveyId,surveyQuestionDto));
    }
    @PutMapping("/{questionId}")
    @LogActivity(value = "Update SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> update(@Valid @PathVariable long questionId, @RequestBody SurveyQuestionDto surveyQuestionDto){
        try{
            return ResponseEntity.ok(surveyQuestionService.update(questionId, surveyQuestionDto));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{questionId}")
    @LogActivity(value = "Delete SurveyQuestion")
    public ResponseEntity<Boolean> delete(@PathVariable long questionId){
        try{
            return ResponseEntity.ok(surveyQuestionService.delete(questionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }
    @PostMapping("/{questionId}/add-choice")
    @LogActivity(value = "Add choice")
    public ResponseEntity<Boolean> addChoice(@PathVariable long questionId, @RequestBody ChoiceDto choiceDto){
        return ResponseEntity.ok(surveyQuestionService.addChoice(questionId,choiceDto));
    }
}
