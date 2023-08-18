package com.example.projectmid.Services;

import com.example.projectmid.Entities.News;
import com.example.projectmid.Repositories.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public void save(News news) {
        newsRepository.save(news);
    }

    public void update(Integer id, News news) {
        news.setId(id);
        newsRepository.save(news);
    }

    public void deleteById(int id) {
        newsRepository.deleteById(id);
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News findById(int id) {
        return newsRepository.findById(id).orElse(null);
    }
}
