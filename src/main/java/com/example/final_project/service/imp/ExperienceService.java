package com.example.final_project.service.imp;

import com.example.final_project.dto.ExperienceDto;
import com.example.final_project.entity.Experience;
import com.example.final_project.repository.ExperienceRepo;
import com.example.final_project.service.IExperienceService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExperienceService implements IExperienceService {
    @Autowired
    private ExperienceRepo experienceRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void add(ExperienceDto experience) {
        var experienceVal = modelMapper.map(experience, Experience.class);
        experienceRepo.save(experienceVal);
    }

    @Override
    public List<ExperienceDto> findAll() {
        var experiences = experienceRepo.findAllPresent();
        var experienceDtoList = new ArrayList<ExperienceDto>();
        experiences.forEach(add->{
            var data = modelMapper.map(add,ExperienceDto.class);
            experienceDtoList.add(data);
        });
        return experienceDtoList;
    }

    @Override
    public ExperienceDto findById(Long id) {
        var experience = experienceRepo.findPresentById(id).get();
        return modelMapper.map(experience, ExperienceDto.class);
    }

    @Override
    public void updateExperience(ExperienceDto experience, Long id) {
        if(experienceRepo.findPresentById(id).isPresent()) {
            var experienceVal = modelMapper.map(experience, Experience.class);
            experienceVal.setId(id);
            experienceRepo.save(experienceVal);
        }
        else {
            throw new ObjectNotFoundException(id, "Experience");
        }
    }

    @Override
    public void deleteExperience(Long id) {
        if(experienceRepo.findPresentById(id).isPresent()){
            var experience = experienceRepo.findPresentById(id).get();
            experience.setDeleted(true);
            experienceRepo.save(experience);
        }
        else{
            throw new ObjectNotFoundException(id, "No Experience found with this id");
        }
    }
}
