package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.News;
import org.springers.waa_alumniplatform.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAll(){
        return ResponseEntity.ok(newsService.getAll());
    }

    @GetMapping("/{news_Id}")
    public ResponseEntity<News> getOne(@PathVariable int news_Id){
        return ResponseEntity.ok(newsService.getById(news_Id));
    }
}
