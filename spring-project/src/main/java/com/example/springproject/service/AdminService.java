package com.example.springproject.service;

import com.example.springproject.entity.Job;

import java.util.List;

public interface AdminService {
    public void add(Job job);
    public void remove(int id);
    public List<Job> finalAll();
    public void update(Job job);
}
