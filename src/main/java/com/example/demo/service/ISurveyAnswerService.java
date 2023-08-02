package com.example.demo.service;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;

import java.util.List;

public interface ISurveyAnswerService {

    SurveyAnswerDto getById(long id);
    SurveyAnswerDto save(long surveyQuestionId,SurveyAnswerDto surveyAnswerDto);
    List<SurveyAnswerDto> getAll();
    SurveyAnswerDto update(long surveyAnswerId,SurveyAnswerDto surveyAnswerDto) throws IllegalAccessException;
    boolean delete(long surveyAnswerId);
}
