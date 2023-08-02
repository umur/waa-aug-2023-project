package com.example.demo.service;

import com.example.demo.dto.ChoiceDto;
import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.entity.Choice;

import java.util.List;
import java.util.Optional;

public interface ISurveyQuestionService {

    SurveyQuestionDto getById(long id);
    SurveyQuestionDto save(SurveyQuestionDto surveyQuestionDto);
    List<SurveyQuestionDto> getAll();
    SurveyQuestionDto update(long questionId,SurveyQuestionDto surveyQuestionDto);
    boolean delete(long surveyQuestionId);
}
