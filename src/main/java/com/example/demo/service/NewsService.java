package com.example.demo.service;

import com.example.demo.dto.NewsDto;

import java.util.List;

public interface NewsService {
    NewsDto createNews(NewsDto news);

    NewsDto updateNews(Long newsId, NewsDto news);

    void deleteNews(Long newsId);

    List<NewsDto> getAllNews();

    NewsDto getNewsById(Long newsId);
}
