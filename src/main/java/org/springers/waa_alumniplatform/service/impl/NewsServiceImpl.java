package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.Admin;
import org.springers.waa_alumniplatform.entity.News;
import org.springers.waa_alumniplatform.exception.EntityNotFound;
import org.springers.waa_alumniplatform.repository.NewsRepo;
import org.springers.waa_alumniplatform.service.AdminService;
import org.springers.waa_alumniplatform.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final AdminService adminService;
    private final NewsRepo newsRepo;
    @Override
    public News persist(News news, int admin_Id) {
        Admin admin = adminService.getById(admin_Id);
        news.setPoster(admin);
        return newsRepo.save(news);
    }

    @Override
    public News updateOne(News news, int newsId) {
        News newsInDB = getById(newsId);
        newsInDB.setTitle(news.getTitle());
        newsInDB.setDescription(news.getDescription());
        return newsRepo.save(newsInDB);
    }

    @Override
    public News getById(int newsId){
        News news = newsRepo.findById(newsId)
                .orElseThrow(()-> new EntityNotFound("News not found"));
        return news;
    }

    @Override
    public List<News> getAll() {
        return newsRepo.findAll();
    }
}
