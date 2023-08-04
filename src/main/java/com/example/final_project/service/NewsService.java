package com.example.final_project.service;

import com.example.final_project.dto.NewsDto;

import java.util.List;

public interface NewsService {
    public List<NewsDto> getAllNews();
    public NewsDto getNewsById(Long id);
    public void save(NewsDto News);
    public void delete(Long id);
    public void update(NewsDto News);

   public void save2(NewsDto dto, Long userId);
}
