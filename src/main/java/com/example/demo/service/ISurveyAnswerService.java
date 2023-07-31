package com.example.demo.service;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;

import java.util.List;

public interface ISurveyAnswerService {

    SurveyAnswerDto getById(long id);
    SurveyAnswerDto save(long userId,SurveyAnswerDto surveyAnswerDto);
    List<SurveyAnswerDto> getAll();
    SurveyAnswerDto update(long userId, long surveyAnswerId,SurveyAnswerDto surveyAnswerDto) throws IllegalAccessException;
    boolean delete(long userId,long surveyAnswerId) throws IllegalAccessException;
}
