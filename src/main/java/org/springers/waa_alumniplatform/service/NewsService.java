package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.entity.News;

import java.util.List;

public interface NewsService {
    News persist(News news, int admin_Id);

    News updateOne(News news, int newsId);
    News getById(int newsId);

    List<News> getAll();
}
