package com.example.demo.service;

import com.example.demo.dto.ChoiceDto;
import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.entity.Choice;

import java.util.List;
import java.util.Optional;

public interface ISurveyQuestionService {

    SurveyQuestionDto getById(int id);
    SurveyQuestionDto save(Integer userId, SurveyQuestionDto surveyQuestionDto);
    List<SurveyQuestionDto> getAll();
    SurveyQuestionDto update(int userId,int questionId,SurveyQuestionDto surveyQuestionDto) throws IllegalAccessException;
    boolean delete(int userId,int surveyQuestionId) throws IllegalAccessException;
}
