package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface CourseService {
    CourseDto save(CourseDto courseDto);
    public List<CourseDto> getAll();
    CourseDto getById(long id);
    CourseDto update(CourseDto courseDto, long id);
    boolean delete(long id);
}
