package com.example.final_project.repository;

import com.example.final_project.entity.News;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepo extends ListCrudRepository<News,Long> {
}
