package com.example.demo.service.impl;

import com.example.demo.dto.SurveyDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Survey;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ISurveyRepo;
import com.example.demo.repository.UserRepo;
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
public class SurveyService implements ISurveyService {

    @Autowired
    private ISurveyRepo surveyRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public SurveyDto getById(long id) {
        Optional<Survey> survey=surveyRepo.findById(id);
        if(survey.isPresent()&&!survey.get().isDeleted()){
            return modelMapper.map(survey,SurveyDto.class);
        }
        throw new ResourceNotFoundException("Survey not found");
    }

    @Override
    public SurveyDto save(SurveyDto surveyDto) {
//        User user=userRepo.findById(userId)
//                .orElseThrow(()->new ResourceNotFoundException("User not found","id",userId));
//        User user =userRepo.findById(userId).orElse(null);
        surveyDto.setActive(surveyDto.getStartDate().isBefore(LocalDateTime.now()) && surveyDto.getEndDate().isAfter(LocalDateTime.now()));
//        surveyDto.setSurveyAuthor(modelMapper.map(user, UserDto.class));
        surveyDto.setCreatedAt(LocalDateTime.now());
        surveyDto.setUpdateAt(LocalDateTime.now());
        Survey survey=modelMapper.map(surveyDto,Survey.class);
        surveyRepo.save(survey);
        return surveyDto;
    }

    @Override
    public List<SurveyDto> getAll() {
        List<SurveyDto>dtoList= surveyRepo.findAll()
                .stream().filter(survey->!survey.isDeleted())
                .map(survey->modelMapper.map(survey,SurveyDto.class))
                .toList();
        if(dtoList.isEmpty()) throw new ResourceNotFoundException("No resource found");
        return dtoList;
    }

    @Override
    public SurveyDto update(long surveyId, SurveyDto surveyDto) {
        Optional<Survey> survey= surveyRepo.findById(surveyId);
        if(survey.isPresent()&&!survey.get().isDeleted()){
            Survey surveyEntity=survey.get();
//            if(surveyEntity.getSurveyAuthor().getId()==userId){
                modelMapper.map(surveyDto,surveyEntity);
                surveyEntity.setUpdateAt(LocalDateTime.now());
                surveyEntity.setActive(surveyDto.getStartDate().isBefore(LocalDateTime.now()) && surveyDto.getEndDate().isAfter(LocalDateTime.now()));
                surveyRepo.save(surveyEntity);
                modelMapper.map(surveyEntity,surveyDto);

                return surveyDto;

//            }
//            else throw new IllegalAccessException("User does not have permission to update the survey.");
        }
        else throw new ResourceNotFoundException("Survey not found for ","id: ",surveyId);

    }

    @Override
    public boolean delete(long surveyId){
        Optional<Survey> survey= surveyRepo.findById(surveyId);
        if(survey.isPresent()){
            var entity=survey.get();
            entity.setDeleted(true);
            surveyRepo.save(entity);
            return true;
        }
        else throw new ResourceNotFoundException("Survey not found for ","id: ",surveyId);

    }
}
