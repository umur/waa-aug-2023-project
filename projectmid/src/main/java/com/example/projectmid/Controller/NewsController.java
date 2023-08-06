package com.example.projectmid.Controller;

import com.example.projectmid.Entities.News;
import com.example.projectmid.Services.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @PostMapping
    public void createNews(@RequestBody News news){
        newsService.save(news);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody News news){
        newsService.update(id, news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        newsService.deleteById(id);
    }

    @GetMapping
    public List<News> findAll(){
        return newsService.findAll();
    }

    @GetMapping("/{id}")
    public News findById(@PathVariable int id){
        return newsService.findById(id);
    }
}
