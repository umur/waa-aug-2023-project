package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {
    private long id;
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    @NotBlank(message = "Description is mandatory")
    @Size(min = 3, max = 50, message = "Description must be between 3 and 50 characters")
    private String description;
    @NotBlank(message = "Start Date is mandatory")
    private LocalDateTime startDate;
    @NotBlank(message = "End Date is mandatory")
    private LocalDateTime endDate;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private boolean isDeleted=false;
    private List<SurveyQuestionDto> surveyQuestionList;
}
