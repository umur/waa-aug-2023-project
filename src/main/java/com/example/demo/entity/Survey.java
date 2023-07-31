package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @ManyToOne
    private User surveyAuthor;
    @OneToMany(mappedBy = "questionSurvey")
    @Cascade(CascadeType.ALL)
    private List<SurveyQuestion> surveyQuestionList;
    @OneToMany(mappedBy = "answerSurvey")
    @Cascade(CascadeType.ALL)
    private List<SurveyAnswer> surveyAnswerList;

//    @OneToMany
//    private List<SurveyAnswer> surveyAnswerList;

//    private Map<Integer, List<SurveyAnswer>> questionIdToAnswersMap;
//    private List<SurveyAnswer> surveyAnswerList;




}
