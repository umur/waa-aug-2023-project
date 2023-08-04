package com.example.final_project.service;

import com.example.final_project.dto.ProfileDto;

import java.util.List;

public interface IProfileService {
    void add(ProfileDto job);
    List<ProfileDto> findAll();
    ProfileDto findById(Long id);
    void update(ProfileDto job, Long id);
    void delete(Long id);
}
