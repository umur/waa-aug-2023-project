package com.example.springproject.repository;

import com.example.springproject.entity.Student;
import com.example.springproject.entity.Survey;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends ListCrudRepository<Survey, Integer> {

}
