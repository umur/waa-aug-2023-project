package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private long id;
    private String question;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    private boolean isRequired;
    private boolean isDeleted=false;
    @OneToMany
    @JoinColumn(name="survey_Question_id")
    @Cascade(CascadeType.ALL)
    private List<Choice> choiceList;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "surveyQuestion")
    @Cascade(CascadeType.ALL)
    @JsonManagedReference(value = "surveyAnswerListManagedReference")
    private List<SurveyAnswer> surveyAnswerList;
    @ManyToOne
    @JsonBackReference(value = "questionSurveyBackReference")
    private Survey survey;

    public void addChoice(Choice choice) {
        choiceList.add(choice);
    }
}
