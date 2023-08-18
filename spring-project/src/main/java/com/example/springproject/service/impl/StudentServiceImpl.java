package com.example.springproject.service.impl;

import com.example.springproject.entity.Student;
import com.example.springproject.repository.StudentRepo;
import com.example.springproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public void add(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void remove(int id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            studentRepo.delete(student.get());
        }

    }

    @Override
    public List<Student> findAll() {

        return studentRepo.findAll();
    }

    @Override
    public void update(Student student) {
        Optional<Student> studentO = studentRepo.findById(student.getId());
        if(studentO.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            studentRepo.save(student);
        }
    }

    @Override
    public List<Student> findByGradution(String year) {
        return studentRepo.findByGraduationYear(year);
    }
    @Override
    public List<Student> findByCourse(String course) {
        return studentRepo.findByCoursesContaining(course);
    }

    @Override
    public List<Student> findByLocation(String city) {
        return studentRepo.findByAddress_City(city);
    }

    @Override
    public List<Student> findByIndustry(String industry) {
        return studentRepo.findByIndustry(industry);
    }

    @Override
    public Student findById(int studentId) {
        Optional<Student> student = studentRepo.findById(studentId);
        if(student.isEmpty()){
            throw new IllegalArgumentException();
        }
        return student.get();
    }
}
