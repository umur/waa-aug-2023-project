package com.example.demo.service;

import com.example.demo.dto.NewsDto;

import java.util.List;

public interface NewsService {
    NewsDto createNews(NewsDto news);

    NewsDto updateNews(Integer newsId, NewsDto news);

    void deleteNews(Integer newsId);

    List<NewsDto> getAllNews();

    NewsDto getNewsById(Integer newsId);
}
