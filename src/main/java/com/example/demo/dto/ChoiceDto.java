package com.example.demo.dto;

import com.example.demo.entity.SurveyQuestion;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceDto {
    private long id;
    private String content;
}

