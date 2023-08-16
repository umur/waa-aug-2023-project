package com.example.demo.service.impl;

import com.example.demo.dto.SurveyAnswerDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.SurveyAnswer;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyAnswerRepo;
import com.example.demo.repository.ISurveyQuestionRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.ISurveyAnswerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class SurveyAnswerService implements ISurveyAnswerService {
    @Autowired
    private ISurveyAnswerRepo surveyAnswerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ISurveyQuestionRepo surveyQuestionRepo;


    @Override
    public SurveyAnswerDto getById(long id) {
        Optional<SurveyAnswer> surveyAnswer = surveyAnswerRepo.findById(id);
        if(surveyAnswer.isPresent()&&!surveyAnswer.get().isDeleted()){
            return modelMapper.map(surveyAnswer, SurveyAnswerDto.class);
        }
        throw new ResourceNotFoundException("Survey answer not found");
    }

    @Override
    public SurveyAnswerDto save(long userId,long surveyQuestionId,SurveyAnswerDto surveyAnswerDto) {
        User user =userRepo.findById(userId).orElse(null);
        var question=surveyQuestionRepo.findById(surveyQuestionId);
        if(question.isPresent()&&!question.get().isDeleted()){
            SurveyQuestionDto surveyQuestionDto=modelMapper.map(question.orElse(null),SurveyQuestionDto.class);
            surveyAnswerDto.setUser(modelMapper.map(user, UserDto.class));
            surveyAnswerDto.setSurveyQuestion(surveyQuestionDto);
            surveyAnswerDto.setCreatedAt(LocalDateTime.now());
            SurveyAnswer surveyAnswer= modelMapper.map(surveyAnswerDto,SurveyAnswer.class);
            surveyAnswerRepo.save(surveyAnswer);
            return surveyAnswerDto;
        }
        throw new ResourceNotFoundException("Survey question not found");

    }

    @Override
    public List<SurveyAnswerDto> getAll() {
        List<SurveyAnswerDto>dtoList= surveyAnswerRepo.findAll()
                .stream().filter(surveyAnswer -> !surveyAnswer.isDeleted())
                .map(answer->modelMapper.map(answer,SurveyAnswerDto.class))
                .toList();
        if(dtoList.isEmpty()) throw new ResourceNotFoundException("No survey answer found");
        return dtoList;
    }

    @Override
    public SurveyAnswerDto update(long surveyAnswerId, SurveyAnswerDto surveyAnswerDto){
        Optional<SurveyAnswer> surveyAnswer= surveyAnswerRepo.findById(surveyAnswerId);
        if(surveyAnswer.isPresent()&&!surveyAnswer.get().isDeleted()){
            SurveyAnswer surveyAnswerEntity=surveyAnswer.get();
                modelMapper.map(surveyAnswerDto,surveyAnswerEntity);
                surveyAnswerRepo.save(surveyAnswerEntity);
                return surveyAnswerDto;

        }
        else throw new ResourceNotFoundException("Answer not found");
    }

    @Override
    public boolean delete(long surveyAnswerId)  {
        Optional <SurveyAnswer> surveyAnswer= surveyAnswerRepo.findById(surveyAnswerId);
        if(surveyAnswer.isPresent()){
            var entity=surveyAnswer.get();
            entity.setDeleted(true);
            surveyAnswerRepo.save(entity);
            return true;
        }
        else throw new ResourceNotFoundException("Survey question not found");
    }
}
