package com.example.demo.dto;

import com.example.demo.entity.QuestionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyQuestionDto {
    private long id;
    @NotBlank(message = "Question is mandatory")
    @Size(min = 3, max = 50, message = "Question must be between 3 and 50 characters")
    private String question;
    @NotBlank(message = "Question Type is mandatory")
    private QuestionType questionType;
    private boolean isRequired;
    private List<ChoiceDto> choiceList;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private boolean isDeleted=false;
    @JsonManagedReference(value = "surveyAnswerListManagedReference")
    private List<SurveyAnswerDto> surveyAnswerList;
    @JsonBackReference(value = "questionSurveyBackReference")
    private SurveyDto questionSurvey;


}
