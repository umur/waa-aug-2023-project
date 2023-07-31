package com.example.demo.service;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;

import java.util.List;

public interface ISurveyAnswerService {

    SurveyAnswerDto getById(int id);
    SurveyAnswerDto save(Integer userId,SurveyAnswerDto surveyAnswerDto);
    List<SurveyAnswerDto> getAll();
    SurveyAnswerDto update(int userId, int surveyAnswerId,SurveyAnswerDto surveyAnswerDto) throws IllegalAccessException;
    boolean delete(int userId,int surveyAnswerId) throws IllegalAccessException;
}
