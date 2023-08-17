package com.example.springproject.controller;

import com.example.springproject.entity.News;
import com.example.springproject.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NewsController {
    private final NewsService newsService;


    @PostMapping
    public ResponseEntity<String> add(@RequestBody News news) {
        newsService.add(news);
        return ResponseEntity.ok("post is working correctly");
    }

    @GetMapping
    public List<News> get() {
        return newsService.findAll();
    }
    @GetMapping("/{id}")
    public News getNewsById(@PathVariable int id) {
    	return newsService.get(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        newsService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody News news){
        newsService.update(news);
        return ResponseEntity.ok("update is working correctly");

    }

}
