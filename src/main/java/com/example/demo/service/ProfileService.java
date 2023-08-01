package com.example.demo.service;

import com.example.demo.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto save(ProfileDto profileDto);
    public List<ProfileDto> getAll();
    ProfileDto getById(long id);
    ProfileDto update(ProfileDto profileDto, long id);
    boolean delete(long id);
    public List<ProfileDto> getProfilesByGraduationYear(Integer graduationYear);
    }
