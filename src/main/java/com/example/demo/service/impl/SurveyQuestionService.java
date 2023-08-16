package com.example.demo.service.impl;

import com.example.demo.dto.ChoiceDto;
import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyQuestionRepo;
import com.example.demo.repository.ISurveyRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.ISurveyQuestionService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurveyQuestionService implements ISurveyQuestionService {
    @Autowired
    private ISurveyQuestionRepo surveyQuestionRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ISurveyRepo surveyRepo;
    @Override
    public SurveyQuestionDto getById(long id) {
        Optional<SurveyQuestion> surveyQuestion=surveyQuestionRepo.findById(id);
        if(surveyQuestion.isPresent()&&!surveyQuestion.get().isDeleted()){
            return modelMapper.map(surveyQuestion, SurveyQuestionDto.class);
        }
        throw new ResourceNotFoundException("Survey question not found");
    }

    @Override
    public SurveyQuestionDto save(long userId,long surveyId,SurveyQuestionDto surveyQuestionDto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if(!user.isDeleted()) {
            Survey survey = surveyRepo.findById(surveyId).orElse(null);
            var surveyDto = modelMapper.map(survey, SurveyDto.class);
            surveyQuestionDto.setQuestionSurvey(surveyDto);
            surveyQuestionDto.setCreatedAt(LocalDateTime.now());
            surveyQuestionDto.setUpdateAt(LocalDateTime.now());
            SurveyQuestion surveyQuestion = modelMapper.map(surveyQuestionDto, SurveyQuestion.class);
            surveyQuestionRepo.save(surveyQuestion);
            return surveyQuestionDto;
        }
        else throw new ResourceNotFoundException("User not found");
    }

    @Override
    public List<SurveyQuestionDto> getAll(long surveyId) {
        Optional<Survey> survey=surveyRepo.findById(surveyId);
        if(survey.isPresent()&&!survey.get().isDeleted()) {
            List<SurveyQuestionDto> dtoList = survey.get().getSurveyQuestionList()
                    .stream().filter(surveyQuestion -> !surveyQuestion.isDeleted())
                    .map(question -> modelMapper.map(question, SurveyQuestionDto.class))
                    .toList();
            if (dtoList.isEmpty()) throw new ResourceNotFoundException("No survey question found");
            return dtoList;
        }
        else throw new ResourceNotFoundException("No survey question found");
    }

    @Override
    public SurveyQuestionDto update(long questionId, SurveyQuestionDto surveyQuestionDto){
        Optional<SurveyQuestion> surveyQuestion= surveyQuestionRepo.findById(questionId);
        if(surveyQuestion.isPresent()&&!surveyQuestion.get().isDeleted()){
            SurveyQuestion surveyQuestionEntity=surveyQuestion.get();
            Survey survey = surveyQuestionEntity.getSurvey();
            modelMapper.map(surveyQuestionDto,surveyQuestionEntity);
            surveyQuestionEntity.setUpdateAt(LocalDateTime.now());
            surveyQuestionEntity.setSurvey(survey);
            surveyQuestionRepo.save(surveyQuestionEntity);
            modelMapper.map(surveyQuestionEntity,surveyQuestionDto);
            return surveyQuestionDto;
        }
        else throw new ResourceNotFoundException("Question not found");
    }

    @Override
    public boolean delete(long surveyQuestionId){
        Optional<SurveyQuestion> surveyQuestion= surveyQuestionRepo.findById(surveyQuestionId);
        if(surveyQuestion.isPresent()){
            var entity=surveyQuestion.get();
            entity.setDeleted(true);
            surveyQuestionRepo.save(entity);
            return true;
        }
        else throw new ResourceNotFoundException("Survey question not found");
    }

    @Override
    public boolean addChoice(long questionId, ChoiceDto choiceDto) {
        Optional<SurveyQuestion> surveyQuestion= surveyQuestionRepo.findById(questionId);
        if(surveyQuestion.isPresent()){
            var entity=surveyQuestion.get();
            if(entity.getQuestionType()== QuestionType.CHECK_BOX||entity.getQuestionType()== QuestionType.RADIO_BUTTON&& !entity.isDeleted()) {
                Choice choice = modelMapper.map(choiceDto, Choice.class);
                entity.addChoice(choice);
                surveyQuestionRepo.save(entity);
                return true;
            }

            else throw new ResourceNotFoundException("Choice not required for this question");
        }
        else throw new ResourceNotFoundException("Survey question not found");
    }
}
