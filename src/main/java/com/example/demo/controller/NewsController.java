package com.example.demo.controller;

import com.example.demo.annotation.LogActivity;
import com.example.demo.dto.NewsDto;
import com.example.demo.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@Validated
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private  NewsService newsService;

    @PostMapping("/user/{userId}")
    @LogActivity(value = "Post news")
    public ResponseEntity<NewsDto> createNews(@Valid  @PathVariable long userId, @RequestBody NewsDto newsDto) {
        NewsDto createdNews = newsService.createNews(userId, newsDto);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    @PutMapping("/{newsId}/user/{userId}")
    @LogActivity(value = "Update news")
    public ResponseEntity<NewsDto> updateNews(
            @Valid
            @PathVariable long userId,
            @PathVariable Long newsId,
             @RequestBody NewsDto newsDto
    ) throws IllegalAccessException {
        NewsDto updatedNews = newsService.updateNews(userId, newsId, newsDto);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{newsId}")
    @LogActivity(value = "Delete news")
    public ResponseEntity<Void> deleteNews(@PathVariable Long newsId) {
        newsService.deleteNews(newsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @LogActivity(value = "Get all news")
    public ResponseEntity<List<NewsDto>> getAllNews() {
        List<NewsDto> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/{newsId}")
    @LogActivity(value = "Get news")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long newsId) {
        NewsDto news = newsService.getNewsById(newsId);
        if (news != null) {
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
