package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class SurveyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private QuestionType questionType;
    private boolean isRequired;
//    @Embedded
//    @ElementCollection
//    @CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
    @OneToMany(mappedBy = "surveyQuestion")
    @Cascade(CascadeType.ALL)
    private List<Choice> choiceList;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @ManyToOne
    private Survey questionSurvey;
    @OneToMany(mappedBy = "surveyQuestion")
    @Cascade(CascadeType.ALL)
    private List<SurveyAnswer> surveyAnswerList;
    @ManyToOne
    private User questionAuthor;
}
