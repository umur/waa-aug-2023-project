package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Answer is mandatory")
    private String answer;
    private LocalDateTime createdAt;
    private boolean isDeleted=false;
    @JsonBackReference(value = "surveyAnswerListManagedReference")
    private SurveyQuestionDto surveyQuestion;
    @JsonBackReference(value="userReference")
    private UserDto user;

}
