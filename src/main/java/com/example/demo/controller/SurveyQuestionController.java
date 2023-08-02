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
@RequestMapping("/surveys/surveyQuestions")
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
    public ResponseEntity<SurveyQuestionDto> getById(@PathVariable long surveyQuestionId) {
        try{
            return ResponseEntity.ok(surveyQuestionService.getById(surveyQuestionId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<SurveyQuestionDto> save(@RequestBody SurveyQuestionDto surveyQuestionDto){
        return ResponseEntity.ok(surveyQuestionService.save(surveyQuestionDto));
    }
    @PutMapping("/{surveyQuestionId}")
    public ResponseEntity<SurveyQuestionDto> update(@PathVariable long surveyQuestionId,
                                                    @RequestBody SurveyQuestionDto surveyQuestionDto){
        try{
            return ResponseEntity.ok(surveyQuestionService.update(surveyQuestionId, surveyQuestionDto));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{surveyQuestionId}")
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
