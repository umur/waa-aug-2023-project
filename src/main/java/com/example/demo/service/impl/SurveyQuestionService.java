package com.example.demo.service.impl;

import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.SurveyQuestionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyQuestionRepo;
import com.example.demo.repository.ISurveyRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.ISurveyQuestionService;
import com.example.demo.service.ISurveyService;
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
    public SurveyQuestionDto save(SurveyQuestionDto surveyQuestionDto) {
//        User user =userRepo.findById(userId).orElse(null);
//        Survey survey=surveyRepo.findById(surveyId).orElse(null);
//        var surveyDto= modelMapper.map(survey,SurveyDto.class);

//        surveyQuestionDto.setQuestionAuthor(modelMapper.map(user, UserDto.class));
//        surveyQuestionDto.setQuestionSurvey(surveyDto);
        surveyQuestionDto.setCreatedAt(LocalDateTime.now());
        surveyQuestionDto.setUpdateAt(LocalDateTime.now());

        SurveyQuestion surveyQuestion= modelMapper.map(surveyQuestionDto,SurveyQuestion.class);
        surveyQuestionRepo.save(surveyQuestion);
        return surveyQuestionDto;
    }

    @Override
    public List<SurveyQuestionDto> getAll() {
        List<SurveyQuestionDto>dtoList= surveyQuestionRepo.findAll()
                .stream().filter(surveyQuestion -> !surveyQuestion.isDeleted())
                .map(question->modelMapper.map(question,SurveyQuestionDto.class))
                .toList();
        if(dtoList.isEmpty()) throw new ResourceNotFoundException("No survey question found");
        return dtoList;
    }

    @Override
    public SurveyQuestionDto update(long questionId, SurveyQuestionDto surveyQuestionDto){
        Optional<SurveyQuestion> surveyQuestion= surveyQuestionRepo.findById(questionId);
        if(surveyQuestion.isPresent()&&!surveyQuestion.get().isDeleted()){
            SurveyQuestion surveyQuestionEntity=surveyQuestion.get();
//            if(surveyQuestionEntity.getQuestionAuthor().getId()==userId){
                modelMapper.map(surveyQuestionDto,surveyQuestionEntity);
                surveyQuestionEntity.setUpdateAt(LocalDateTime.now());
                surveyQuestionRepo.save(surveyQuestionEntity);
                modelMapper.map(surveyQuestionEntity,surveyQuestionDto);
                return surveyQuestionDto;
//            }
//            else throw new IllegalAccessException("User does not have permission to update the question.");
        }
        else throw new ResourceNotFoundException("Question not found");
    }

    @Override
    public boolean delete(long surveyQuestionId){
        Optional<SurveyQuestion> surveyQuestion= surveyQuestionRepo.findById(surveyQuestionId);//.orElseThrow(()->new ResourceNotFoundException("Survey question not found"));
        if(surveyQuestion.isPresent()){
            var entity=surveyQuestion.get();
            entity.setDeleted(true);
            surveyQuestionRepo.save(entity);
            return true;
        }
        else throw new ResourceNotFoundException("Survey question not found");
    }
}
