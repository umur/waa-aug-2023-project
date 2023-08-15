package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Validated
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    @LogActivity(value = "Post course")
    public ResponseEntity<CourseDto> save(@Valid @RequestBody CourseDto courseDto){
        CourseDto createdCourse = courseService.save(courseDto);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    @LogActivity(value = "Get all courses")
    public ResponseEntity<List<CourseDto>> getAll(){
        List<CourseDto> courseDtoList = courseService.getAll();
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping("/{id}")
    @LogActivity(value = "Get course")
    public ResponseEntity<CourseDto> getById(@PathVariable Long id){
        CourseDto courseDto = courseService.getById(id);
        if(courseDto != null) return ResponseEntity.ok(courseDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @LogActivity(value = "Update course")
    public ResponseEntity<CourseDto> update(@Valid @PathVariable Long id, @RequestBody CourseDto courseDto){
        CourseDto updatedCourse = courseService.update(courseDto, id);
        if(updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    @LogActivity(value = "Delete course")
    public ResponseEntity delete(@PathVariable Long id){
        boolean deleted = courseService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
