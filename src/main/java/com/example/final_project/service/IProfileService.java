package com.example.final_project.service;

import com.example.final_project.dto.ProfileDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProfileService {
    void add(ProfileDto job,HttpServletRequest request);
    List<ProfileDto> findAll();
    ProfileDto findById(HttpServletRequest request);
    void update(ProfileDto job, HttpServletRequest request);
    void delete(HttpServletRequest request);
}
