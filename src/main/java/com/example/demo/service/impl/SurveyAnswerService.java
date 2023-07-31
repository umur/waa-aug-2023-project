package com.example.demo.service.impl;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.entity.SurveyAnswer;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyAnswerRepo;
import com.example.demo.repository.ISurveyQuestionRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.ISurveyAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class SurveyAnswerService implements ISurveyAnswerService {
    @Autowired
    private ISurveyAnswerRepo surveyAnswerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;


    @Override
    public SurveyAnswerDto getById(long id) {
        Optional<SurveyAnswer> surveyAnswer = surveyAnswerRepo.findById(id);
        if(surveyAnswer.isPresent()){
            return modelMapper.map(surveyAnswer, SurveyAnswerDto.class);
        }
        throw new ResourceNotFoundException("Survey answer not found");
    }

    @Override
    public SurveyAnswerDto save(long userId, SurveyAnswerDto surveyAnswerDto) {
        /*
        * must set to question and survey
        * */
        User user =userRepo.findById(userId).orElse(null);
        surveyAnswerDto.setUser(user);
        surveyAnswerDto.setCreatedAt(LocalDateTime.now());
        SurveyAnswer surveyAnswer= modelMapper.map(surveyAnswerDto,SurveyAnswer.class);
        surveyAnswerRepo.save(surveyAnswer);
        return surveyAnswerDto;

    }

    @Override
    public List<SurveyAnswerDto> getAll() {
        List<SurveyAnswerDto>dtoList= surveyAnswerRepo.findAll()
                .stream()
                .map(answer->modelMapper.map(answer,SurveyAnswerDto.class))
                .toList();
        if(dtoList.isEmpty()) throw new ResourceNotFoundException("No survey question found");
        return dtoList;
    }

    @Override
    public SurveyAnswerDto update(long userId, long surveyAnswerId, SurveyAnswerDto surveyAnswerDto) throws IllegalAccessException {
        Optional<SurveyAnswer> surveyAnswer= surveyAnswerRepo.findById(surveyAnswerId);
        if(surveyAnswer.isPresent()){
            SurveyAnswer surveyAnswerEntity=surveyAnswer.get();
            if(surveyAnswerEntity.getUser().getId()==userId){
                modelMapper.map(surveyAnswerDto,surveyAnswerEntity);
                surveyAnswerRepo.save(surveyAnswerEntity);
//                modelMapper.map(surveyAnswerEntity,surveyAnswerDto);
                return surveyAnswerDto;
            }
            else throw new IllegalAccessException("User does not have permission to update the answer.");
        }
        else throw new ResourceNotFoundException("Answer not found");
    }

    @Override
    public boolean delete(long userId, long surveyAnswerId) throws IllegalAccessException {
        SurveyAnswer surveyAnswer= surveyAnswerRepo.findById(surveyAnswerId).orElseThrow(()->new ResourceNotFoundException("Survey question not found"));
        if(surveyAnswer.getUser().getId()==userId){
            surveyAnswerRepo.deleteById(surveyAnswerId);
            return true;
        }
        else throw new IllegalAccessException("User does not have permission to delete the survey answer.");
    }
}
