package com.example.springproject.service.impl;

import com.example.springproject.entity.Survey;
import com.example.springproject.entity.SurveyResponse;
import com.example.springproject.repository.StudentRepo;
import com.example.springproject.repository.SurveyRepo;
import com.example.springproject.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepo surveyRepo;

    @Override
    public void add(Survey survey) {
        surveyRepo.save(survey);
    }

    @Override
    public void remove(int id) {
        Optional<Survey> survey=surveyRepo.findById(id);
        if(survey.isEmpty()){
            throw new IllegalArgumentException();

        }else{
            surveyRepo.deleteById(id);
        }

    }

    @Override
    public List<Survey> findAll() {
        return surveyRepo.findAll();
    }

    @Override
    public void update(Survey survey) {
        Optional<Survey> survey1=surveyRepo.findById(survey.getId());
        if(survey1.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            surveyRepo.save(survey);

        }
    }

    @Override
    public void addResponse(int survey_id, SurveyResponse surveyResponse) {
        Optional<Survey> surveyO = surveyRepo.findById(survey_id);
        if(surveyO.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            Survey survey = surveyO.get();
            List<SurveyResponse> responses = survey.getSurveyResponses();
            responses.add(surveyResponse);
            survey.setSurveyResponses(responses);
            update(survey);
        }
    }

	@Override
	public Survey getById(int id) {
		Optional<Survey> survey = surveyRepo.findById(id);
		if(survey.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		return survey.get();
	}
}
