package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private  ModelMapper modelMapper;
    @Override
    public CourseDto save(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        Course newCourse = courseRepo.save(course);
        return modelMapper.map(newCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courseList = courseRepo.findAll();
        return courseList.stream().map(course ->
                modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(long id) {
        Optional<Course> courseOptional = courseRepo.findById(id);
        if(courseOptional.isEmpty()){
            return null;
        }
        Course course = courseOptional.get();
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto update(CourseDto courseDto, long id) {
        if(!courseRepo.existsById(id)){
            return null;
        }
        CourseDto entityDto = getById(id);
        Course course = modelMapper.map(entityDto, Course.class);
        if(courseDto.getName() != null) course.setName(courseDto.getName());
        if(courseDto.getProfile() != null) course.setProfile(courseDto.getProfile());

        Course updatedCourse = courseRepo.save(course);
        return modelMapper.map(updatedCourse, CourseDto.class);
    }

    @Override
    public boolean delete(long id) {
        if(courseRepo.existsById(id)){
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
