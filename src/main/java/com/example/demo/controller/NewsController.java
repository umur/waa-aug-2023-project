package com.example.demo.controller;

import com.example.demo.dto.NewsDto;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    @Autowired
    private final NewsService newsService;

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto) {
        NewsDto createdNews = newsService.createNews(newsDto);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    @PutMapping("/{newsId}")
    public ResponseEntity<NewsDto> updateNews(
            @PathVariable Long newsId,
             @RequestBody NewsDto newsDto
    )
    {
        NewsDto updatedNews = newsService.updateNews(newsId, newsDto);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long newsId) {
        newsService.deleteNews(newsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<NewsDto>> getAllNews() {
        List<NewsDto> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/{newsId}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long newsId) {
        NewsDto news = newsService.getNewsById(newsId);
        if (news != null) {
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
