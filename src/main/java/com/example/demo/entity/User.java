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
    @Enumerated(EnumType.STRING)
    private RoleType role;
    
    @Column(nullable = false)
    private boolean isDeleted = false;
    @OneToMany
    @JoinColumn(name="user_id")
    @Cascade(CascadeType.ALL)
    private List<Survey> surveys;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<SurveyAnswer> surveyAnswerList;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<SurveyQuestion> surveyQuestionList;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @OneToOne(mappedBy = "user")
    private Profile profile;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @OneToOne(mappedBy = "user")
    private Job job;

    @JsonManagedReference
    @OneToMany(mappedBy = "organizer")
    @Cascade(CascadeType.ALL)
    private List<Event> events;

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher")
    @Cascade(CascadeType.ALL)
    private List<News> news;
    
}
