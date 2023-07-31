package com.example.springproject.service;

import com.example.springproject.entity.Job;
import com.example.springproject.entity.User;

import java.util.List;

public interface JobService {
    public void add(Job job);
    public void remove(int id);
    public List<Job> finalAll();
    public void update(Job job);

    public void apply(User user);

    public List<Job> getByCity(String city);

    public List<Job> getByState(String state);

    public List<Job> getByCompanyName(String companyName);


}
