package com.example.projectmid.Services;

import com.example.projectmid.Entities.Survey;
import com.example.projectmid.Repositories.SurveyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public void save(Survey survey) {
        surveyRepository.save(survey);
    }

    public void update(Integer id, Survey survey) {
        survey.setId(id);
        surveyRepository.save(survey);
    }

    public void deleteById(int id) {
        surveyRepository.deleteById(id);
    }

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public Survey findById(int id) {
        return surveyRepository.findById(id).orElse(null);
    }
}
