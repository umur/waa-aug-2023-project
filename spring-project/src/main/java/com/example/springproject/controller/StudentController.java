package com.example.springproject.controller;

import com.example.springproject.entity.Student;
import com.example.springproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok("post is working correctly");
    }
    @GetMapping("/graduation/{gradYear}")
    public List<Student> getByGraduation(@PathVariable String gradYear) {
        return studentService.findByGradution(gradYear);
    }
    @GetMapping("/course/{course}")
    public List<Student> getByCourse(@PathVariable String course) {
        return studentService.findByCourse(course);
    }
    @GetMapping("/location/{city}")
    public List<Student> getByLocation(@PathVariable String city) {
        return studentService.findByLocation(city);
    }
    @GetMapping("/industry/{industry}")
    public List<Student> getByIndustry(@PathVariable String industry) {
        return studentService.findByIndustry(industry);
    }

    @GetMapping
    public List<Student> get() {
        return studentService.findAll();
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
