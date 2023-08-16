package com.example.demo.repository;

import com.example.demo.entity.SurveyAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISurveyAnswerRepo extends JpaRepository<SurveyAnswer, Long> {
}
