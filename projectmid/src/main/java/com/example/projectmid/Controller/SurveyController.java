package com.example.projectmid.Controller;

import com.example.projectmid.Entities.Survey;
import com.example.projectmid.Services.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping
    public void createSurvey(@RequestBody Survey survey){
        surveyService.save(survey);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Survey survey){
        surveyService.update(id, survey);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        surveyService.deleteById(id);
    }

    @GetMapping
    public List<Survey> findAll(){
        return surveyService.findAll();
    }

    @GetMapping("/{id}")
    public Survey findById(@PathVariable int id){
        return surveyService.findById(id);
    }
}
