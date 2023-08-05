package com.example.demo.service;

import com.example.demo.dto.SurveyDto;

import java.util.List;
import java.util.Optional;

public interface ISurveyService {
    SurveyDto getById(long id);

    SurveyDto save(long userId,SurveyDto surveyDto);

    List<SurveyDto> getAll();
    SurveyDto update(long surveyId,SurveyDto surveyDto);
    boolean delete(long surveyId);
}
