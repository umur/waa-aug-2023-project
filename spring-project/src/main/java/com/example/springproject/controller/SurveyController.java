package com.example.springproject.controller;

import com.example.springproject.entity.Student;
import com.example.springproject.entity.Survey;
import com.example.springproject.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@CrossOrigin(origins = "*")

public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Survey survey) {
        surveyService.add(survey);
        return ResponseEntity.ok("post is working correctly");
    }


    @GetMapping
    public List<Survey> get() {
        return surveyService.findAll();
    }
    @GetMapping("/{id}")
    public Survey getById(@PathVariable int id) {
    	return surveyService.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        surveyService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Survey survey){
        surveyService.update(survey);
        return ResponseEntity.ok("update is working correctly");

    }
}
