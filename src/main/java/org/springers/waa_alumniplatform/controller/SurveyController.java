package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.survey.SurveyTitle;
import org.springers.waa_alumniplatform.entity.Survey;
import org.springers.waa_alumniplatform.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnus/{alumni_Id}/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService surveyService;

    @GetMapping("/{survey_Id}")
    public ResponseEntity<Survey> getOne(@PathVariable int survey_Id, @PathVariable int alumni_Id){
        return ResponseEntity.ok(surveyService.getOneSpecificToAlumni(survey_Id, alumni_Id));
    }
    @PutMapping("/{survey_Id}")
    public ResponseEntity<Survey> saveSurveyResponses(@RequestBody Survey survey, @PathVariable int survey_Id, @PathVariable int alumni_Id){
        return ResponseEntity.ok(surveyService.saveSurveyResponses(survey, survey_Id, alumni_Id));
    }
    @GetMapping
    public ResponseEntity<List<SurveyTitle>> getAll(){
        return ResponseEntity.ok(surveyService.getAll());
    }

}
