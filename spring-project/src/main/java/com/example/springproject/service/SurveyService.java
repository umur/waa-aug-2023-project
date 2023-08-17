package com.example.springproject.service;

import com.example.springproject.entity.Survey;
import com.example.springproject.entity.SurveyResponse;

import java.util.List;

public interface SurveyService {
    public void add(Survey survey);
    public void remove(int id);
    public List<Survey> findAll();
    public void update(Survey survey);
    public void addResponse(int survey_id, SurveyResponse surveyResponse);
	public Survey getById(int id);

}
