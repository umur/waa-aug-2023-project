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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Email is required")
    @Size(min = 5, max = 30, message = "Email must be between 5 and 30 characters")
    @Email(message = "Email must be a valid email address")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 5, max = 30, message = "Password must be between 5 and 30 characters")
    private String password;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private RoleType role;
    private List<SurveyDto> surveys;
    @JsonManagedReference(value="userReference")
    private List<SurveyAnswerDto> surveyAnswerList;
    private List<SurveyQuestionDto> surveyQuestionList;
    private boolean isDeleted = false;
    private List<Event> events;
    private List<News> news;
}
