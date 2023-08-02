package com.example.demo.service.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.NewsDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.News;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.NewsRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class NewsServiceImpl implements NewsService {

    @Autowired
    private  NewsRepo newsRepo;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;


    @Override
    public NewsDto createNews(long userId, NewsDto newsDto) {
        User user =userRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        News news = modelMapper.map(newsDto, News.class);
        news.setPublisher(user);
        News savedNews = newsRepo.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public NewsDto updateNews(long userId, long newsId, NewsDto newsDto) throws IllegalAccessException {
        News existingNews = newsRepo.findById(newsId).orElse(null);
        if (existingNews == null) {
            return null;
        }

        if (existingNews.getPublisher().getId() != userId) {
            throw new IllegalAccessException("You are not authorized to update this event.");
        }
        // Update the properties of the existing news
        existingNews.setTitle(newsDto.getTitle());
        existingNews.setDescription(newsDto.getDescription());
        existingNews.setPublishDate(newsDto.getPublishDate());

        News updatedNews = newsRepo.save(existingNews);
        return modelMapper.map(updatedNews, NewsDto.class);
    }

    @Override
    public void deleteNews(long newsId) {
        News existingNews = newsRepo.findById(newsId).orElse(null);
        if (existingNews == null) {
            throw new ResourceNotFoundException("News not found with ID: " + newsId);
        }

        existingNews.setDeleted(true); // Soft delete by setting the flag to true
        newsRepo.save(existingNews);
    }

    @Override
    public List<NewsDto> getAllNews() {
        List<News> newsList = newsRepo.findAllByIsDeletedFalse(); // Filter out deleted news
        return newsList.stream()
                .map(news -> modelMapper.map(news, NewsDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public NewsDto getNewsById(long newsId) {
        News news = newsRepo.findByIdAndIsDeletedFalse(newsId); // Find by ID and ensure it's not deleted
        if (news == null) {
            return null;
        }
        return modelMapper.map(news, NewsDto.class);
    }
}
