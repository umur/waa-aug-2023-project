package com.example.final_project.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ExperienceDto {
    private String position;
    private String responsibilities;
    private LocalDate startDate;
    private LocalDate endDate;
    private String organization;
}
