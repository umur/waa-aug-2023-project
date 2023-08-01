package com.example.demo.service;

import com.example.demo.dto.NewsDto;

import java.util.List;

public interface NewsService {
    NewsDto createNews(long userId,NewsDto news);

    NewsDto updateNews(long userId, long newsId, NewsDto news) throws IllegalAccessException;

    void deleteNews(long newsId);

    List<NewsDto> getAllNews();

    NewsDto getNewsById(long newsId);
}
