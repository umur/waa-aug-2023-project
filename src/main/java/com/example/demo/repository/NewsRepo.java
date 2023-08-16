package com.example.demo.repository;

import com.example.demo.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News, Long> {

    // Retrieve all news where isDeleted is false
    List<News> findAllByIsDeletedFalse();

    // Retrieve news by ID where isDeleted is false
    News findByIdAndIsDeletedFalse(long newsId);

}
