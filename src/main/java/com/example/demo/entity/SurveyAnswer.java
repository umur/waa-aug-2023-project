package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class SurveyAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answer;
    private LocalDateTime createdAt;
    @ManyToOne
    private SurveyQuestion surveyQuestion;
    @ManyToOne
    private User user;
    @ManyToOne
    private Survey answerSurvey;

}
