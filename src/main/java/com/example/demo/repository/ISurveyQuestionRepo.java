package com.example.demo.repository;

import com.example.demo.entity.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISurveyQuestionRepo extends JpaRepository<SurveyQuestion, Long> {
}
