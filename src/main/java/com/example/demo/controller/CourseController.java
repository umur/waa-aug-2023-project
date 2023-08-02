package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto courseDto){
        CourseDto createdCourse = courseService.save(courseDto);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
        List<CourseDto> courseDtoList = courseService.getAll();
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable int id){
        CourseDto courseDto = courseService.getById(id);
        if(courseDto != null) return ResponseEntity.ok(courseDto);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable int id, @RequestBody CourseDto courseDto){
        CourseDto updatedCourse = courseService.update(courseDto, id);
        if(updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean deleted = courseService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
