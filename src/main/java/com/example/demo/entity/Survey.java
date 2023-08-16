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
import java.util.Map;

@Entity
@Setter
@Getter
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private boolean isDeleted=false;

    @OneToMany(mappedBy = "survey")
    @Cascade(CascadeType.ALL)
    @JsonManagedReference(value = "questionSurveyBackReference")
    private List<SurveyQuestion> surveyQuestionList;

}
