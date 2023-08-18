package com.example.projectmid.Repositories;

import com.example.projectmid.Entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{
}
