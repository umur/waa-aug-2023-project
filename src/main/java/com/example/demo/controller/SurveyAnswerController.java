package com.example.demo.controller;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ISurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("surveys/surveyQuestions/{surveyQuestionId}/answers")
public class SurveyAnswerController {
    @Autowired
    private ISurveyAnswerService surveyAnswerService;

    @GetMapping
    public ResponseEntity<List<SurveyAnswerDto>> getAll(){
        try{
            return ResponseEntity.ok(surveyAnswerService.getAll());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @GetMapping("/{surveyAnswerId}")
    public ResponseEntity<SurveyAnswerDto> getById(@PathVariable long surveyAnswerId) {
        try{
            return ResponseEntity.ok(surveyAnswerService.getById(surveyAnswerId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<SurveyAnswerDto> save(@PathVariable long surveyQuestionId,
                                                @RequestBody SurveyAnswerDto surveyAnswerDto){
        return ResponseEntity.ok(surveyAnswerService.save(surveyQuestionId,surveyAnswerDto));
    }
    @PutMapping("/{surveyAnswerId}")
    public ResponseEntity<SurveyAnswerDto> update(@PathVariable long surveyAnswerId,
                                                  @RequestBody SurveyAnswerDto surveyAnswerDto){
        try{
            return ResponseEntity.ok(surveyAnswerService.update(surveyAnswerId, surveyAnswerDto));
        }
        catch(IllegalAccessException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{surveyAnswerId}")
    public ResponseEntity<Boolean> delete(@PathVariable long surveyAnswerId){
        /*
         * delete should be enabled only for admin
         * */
        try{
            return ResponseEntity.ok(surveyAnswerService.delete(surveyAnswerId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }
}
