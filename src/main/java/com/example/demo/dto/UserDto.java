package com.example.demo.dto;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyAnswer;
import com.example.demo.entity.SurveyQuestion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.demo.entity.Event;
import com.example.demo.entity.News;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private RoleType role;
    private List<Survey> surveys;
    private List<SurveyAnswer> surveyAnswerList;
    private List<SurveyQuestion> surveyQuestionList;
    private boolean isDeleted = false;
    private List<Event> events;
    private List<News> news;
}
