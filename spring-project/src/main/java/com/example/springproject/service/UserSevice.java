package com.example.springproject.service;

import com.example.springproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserSevice {
    public void add(User user);
    public void remove(int id);
    public List<User> finalAll();
    public void update(User address);
    public List<User> findByGradution(String year);
    public List<User> findByCourse(String course);
    public List<User> findByLocation(String city);
    public List<User> findByIndustry(String industry);



}
