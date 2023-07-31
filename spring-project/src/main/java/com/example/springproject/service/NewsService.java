package com.example.springproject.service;

import com.example.springproject.entity.Job;
import com.example.springproject.entity.News;

import java.util.List;

public interface NewsService {
    public void add(News news);
    public void remove(int id);
    public List<News> finalAll();
    public void update(News news);

}
