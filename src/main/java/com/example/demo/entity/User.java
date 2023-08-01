package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private RoleType role = RoleType.STUDENT;

    @OneToMany(mappedBy = "surveyAuthor")
    @Cascade(CascadeType.ALL)
    private List<Survey> surveys;
    @OneToMany(mappedBy = "user")
    @Cascade(CascadeType.ALL)
    private List<SurveyAnswer> surveyAnswerList;
    @OneToMany(mappedBy = "questionAuthor")
    @Cascade(CascadeType.ALL)
    private List<SurveyQuestion> surveyQuestionList;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @OneToOne(mappedBy = "user")
    private Profile profile;
    
}
