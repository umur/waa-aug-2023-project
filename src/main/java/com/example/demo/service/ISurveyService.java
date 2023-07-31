package com.example.demo.service;

import com.example.demo.dto.SurveyDto;

import java.util.List;
import java.util.Optional;

public interface ISurveyService {
    SurveyDto getById(int id);

    SurveyDto save(Integer userId, SurveyDto surveyDto);

    List<SurveyDto> getAll();
    SurveyDto update(int userId, int surveyId,SurveyDto surveyDto) throws IllegalAccessException;
    boolean delete(int userId, int surveyId) throws IllegalAccessException;
}
