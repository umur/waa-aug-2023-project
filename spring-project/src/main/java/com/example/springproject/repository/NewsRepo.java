package com.example.springproject.repository;

import com.example.springproject.entity.Job;
import com.example.springproject.entity.News;
import org.springframework.data.repository.ListCrudRepository;

public interface NewsRepo extends ListCrudRepository<News,Integer> {
}
