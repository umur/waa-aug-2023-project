package com.example.final_project.service;
import com.example.final_project.dto.ExperienceDto;

import java.util.List;

public interface IExperienceService {
    void add(ExperienceDto experience);
    List<ExperienceDto> findAll();
    ExperienceDto findById(Long id);
    void updateExperience(ExperienceDto experience, Long id);
    void deleteExperience(Long id);
}
