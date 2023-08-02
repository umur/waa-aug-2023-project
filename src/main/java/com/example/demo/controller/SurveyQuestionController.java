package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.SurveyDto;
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
@RequestMapping("/surveys/surveyQuestions")
@Validated
public class SurveyQuestionController {
    @Autowired
    private ISurveyQuestionService surveyQuestionService;

    @GetMapping
    @LogActivity(value = "Get all SurveyQuestions")
    public ResponseEntity<List<SurveyQuestionDto>> getAll(){
        try{
            return ResponseEntity.ok(surveyQuestionService.getAll());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{surveyQuestionId}")
    @LogActivity(value = "Get SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> getById(@PathVariable long surveyQuestionId) {
        try{
            return ResponseEntity.ok(surveyQuestionService.getById(surveyQuestionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping
    @LogActivity(value = "Post SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> save(@Valid @RequestBody SurveyQuestionDto surveyQuestionDto){
        return ResponseEntity.ok(surveyQuestionService.save(surveyQuestionDto));
    }
    @PutMapping("/{surveyQuestionId}")
    @LogActivity(value = "Update SurveyQuestion")
    public ResponseEntity<SurveyQuestionDto> update(@Valid @PathVariable long surveyQuestionId, @RequestBody SurveyQuestionDto surveyQuestionDto){
        try{
            return ResponseEntity.ok(surveyQuestionService.update(surveyQuestionId, surveyQuestionDto));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{surveyQuestionId}")
    @LogActivity(value = "Delete SurveyQuestion")
    public ResponseEntity<Boolean> delete(@PathVariable long surveyQuestionId){
        /*
        * delete should be enabled only for admin
        * */
        try{
            return ResponseEntity.ok(surveyQuestionService.delete(surveyQuestionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }
}
