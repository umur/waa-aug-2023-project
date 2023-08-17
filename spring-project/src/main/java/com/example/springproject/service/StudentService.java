package com.example.springproject.service;

import com.example.springproject.entity.Student;

import java.util.List;
public interface StudentService {
    public void add(Student student);
    public void remove(int id);
    public List<Student> findAll();
    public void update(Student address);
    public List<Student> findByGradution(String year);
    public List<Student> findByCourse(String course);
    public List<Student> findByLocation(String city);
    public List<Student> findByIndustry(String industry);


    public Student findById(int studentId);
}
