package com.example.demo.dto;

import com.example.demo.entity.Choice;
import com.example.demo.entity.QuestionType;
import com.example.demo.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyQuestionDto {
    private int id;
    private String question;
    private QuestionType questionType;
    private boolean isRequired;
    private List<Choice> choiceList;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private SurveyDto questionSurvey;
    private List<SurveyAnswerDto> surveyAnswerList;
    private User questionAuthor;
}
