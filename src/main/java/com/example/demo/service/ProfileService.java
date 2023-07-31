package com.example.demo.service;

import com.example.demo.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto save(ProfileDto profileDto);
    public List<ProfileDto> getAll();
    ProfileDto getById(int id);
    ProfileDto update(ProfileDto profileDto, int id);
    boolean delete(int id);
}
