package com.example.demo.controller;

import com.example.demo.dto.SurveyDto;
import com.example.demo.entity.Survey;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyRepo;
import com.example.demo.service.ISurveyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surveys")
@Validated
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
    public ResponseEntity<SurveyDto> getById(@PathVariable long surveyId) {
        try{
            return ResponseEntity.ok(surveyService.getById(surveyId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<SurveyDto> save(@Valid @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.save(surveyDto));
    }
    @PutMapping("/{surveyId}")
    public ResponseEntity<SurveyDto> update(@Valid @PathVariable long surveyId,
                                            @RequestBody SurveyDto surveyDto){
        try{
            return ResponseEntity.ok(surveyService.update(surveyId, surveyDto));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getResourceName());
        }
    }
    @DeleteMapping("/{surveyId}")
    public ResponseEntity<Boolean> delete(@PathVariable long surveyId){
        try{
            return ResponseEntity.ok(surveyService.delete(surveyId));
        }
        catch(ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getResourceName());
        }
    }

}
