package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.*;
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
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private boolean isDeleted=false;
    private List<SurveyQuestionDto> surveyQuestionList;
}
