package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyAnswerDto {
    private long id;
    private String answer;
    private LocalDateTime createdAt;
    private SurveyQuestionDto surveyQuestion;
    private User user;

}
