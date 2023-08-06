package com.example.final_project.dto;

import com.example.final_project.entity.User;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class NewsDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate postedOn;
    private User newsPoster;
    private boolean deleted = false;
}
