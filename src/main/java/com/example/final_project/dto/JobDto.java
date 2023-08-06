package com.example.final_project.dto;

import com.example.final_project.entity.User;
import lombok.Data;

import java.time.LocalDate;
@Data
public class JobDto {
    private String title;
    private String description;
    private int numRequired;
    private LocalDate postedOn;
    private LocalDate closingDate;
    private String companyName;
}
