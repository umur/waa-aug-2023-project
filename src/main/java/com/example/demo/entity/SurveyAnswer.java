package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private long id;
    private String answer;
    private LocalDateTime createdAt;
    private boolean isDeleted=false;
    @ManyToOne
    @JsonBackReference
    private SurveyQuestion surveyQuestion;
//    private User user;

}
