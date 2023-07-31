package com.example.springproject.service;

import com.example.springproject.entity.Job;
import com.example.springproject.entity.Student;
import com.example.springproject.entity.User;

import java.util.List;

public interface EventService {
    public void add(Job job);
    public void remove(int id);
    public List<Job> finalAll();
    public void update(Job job);

    public void RSVP (Student student);
}
