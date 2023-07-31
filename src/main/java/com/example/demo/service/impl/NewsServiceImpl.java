package com.example.demo.service.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.NewsDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.News;
import com.example.demo.repository.NewsRepo;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    @Autowired
    private final NewsRepo newsRepo;
    private final ModelMapper modelMapper;
    @Override
    public NewsDto createNews(NewsDto newsDto) {
        News news = modelMapper.map(newsDto, News.class);
        News savedNews = newsRepo.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public NewsDto updateNews(Long newsId, NewsDto newsDto) {
        News existingNews = newsRepo.findById(newsId).orElse(null);
        if (existingNews == null) {
            return null;
        }

        // Update the properties of the existing news
        existingNews.setTitle(newsDto.getTitle());
        existingNews.setDescription(newsDto.getDescription());
        existingNews.setPublishDate(newsDto.getPublishDate());
//        existingNews.setAuthor(newsDto.getAuthor());

        News updatedNews = newsRepo.save(existingNews);
        return modelMapper.map(updatedNews, NewsDto.class);
    }

    @Override
    public void deleteNews(Long newsId) {
        newsRepo.deleteById(newsId);
    }

    @Override
    public List<NewsDto> getAllNews() {
        List<News> newsList = newsRepo.findAll();
        return newsList.stream()
                .map(news -> modelMapper.map(news, NewsDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public NewsDto getNewsById(Long newsId) {
        News news = newsRepo.findById(newsId).orElse(null);
        if (news == null) {
            return null;
        }
        return modelMapper.map(news, NewsDto.class);
    }
}
