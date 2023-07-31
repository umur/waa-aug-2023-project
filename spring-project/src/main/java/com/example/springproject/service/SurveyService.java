package com.example.springproject.service;

import com.example.springproject.entity.Survey;
import com.example.springproject.entity.SurveyResponse;
import com.example.springproject.entity.User;

import java.util.List;

public interface SurveyService {
    public void add(Survey survey);
    public void remove(int id);
    public List<Survey> finalAll();
    public void update(Survey survey);
    public void addResponse(SurveyResponse surveyResponse);

}
