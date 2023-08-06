package com.example.final_project.controller;

import com.example.final_project.dto.NewsDto;
import com.example.final_project.dto.NewsDto;
import com.example.final_project.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")

public class NewsController {
    private final NewsService newsService;

    @GetMapping
    List<NewsDto> getAll(){
        return newsService.getAllNews();
    }
    @GetMapping("/{id}")
    NewsDto getById(@PathVariable Long id){
        return newsService.getNewsById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Long id){
        newsService.delete(id);
        return ResponseEntity.ok().body("deleted successfully");

    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody NewsDto news){
        newsService.save(news);
        return ResponseEntity.ok().body("created successfully");

    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody NewsDto news){
        newsService.update(news);
        return ResponseEntity.ok().body("updated successfully");
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> save2(@RequestBody NewsDto dto, @PathVariable Long userId){
        newsService.save2(dto, userId);
        return ResponseEntity.ok().body("created successfully");
    }
}
