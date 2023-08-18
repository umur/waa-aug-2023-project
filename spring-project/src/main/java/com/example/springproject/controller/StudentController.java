package com.example.springproject.controller;

import com.example.springproject.entity.Student;
import com.example.springproject.service.StudentService;
import com.example.springproject.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok("post is working correctly");
    }
    @GetMapping("/graduation/{gradYear}")
    @JsonView(Views.StudentControllerView.class)
    public List<Student> getByGraduation(@PathVariable String gradYear) {
        return studentService.findByGradution(gradYear);
    }
    @GetMapping("/course/{course}")
    @JsonView(Views.StudentControllerView.class)
    public List<Student> getByCourse(@PathVariable String course) {
        return studentService.findByCourse(course);
    }
    @GetMapping("/location/{city}")
    @JsonView(Views.StudentControllerView.class)
    public List<Student> getByLocation(@PathVariable String city) {
        return studentService.findByLocation(city);
    }
    @GetMapping("/industry/{industry}")
    @JsonView(Views.StudentControllerView.class)
    public List<Student> getByIndustry(@PathVariable String industry) {
        return studentService.findByIndustry(industry);
    }

    @GetMapping
    @JsonView(Views.StudentControllerView.class)
    public List<Student> get() {
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    @JsonView(Views.StudentControllerView.class)
    public Student getStudentById(@PathVariable int id) {
    	return studentService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        studentService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Student student){
        studentService.update(student);
        return ResponseEntity.ok("update is working correctly");

    }


}
