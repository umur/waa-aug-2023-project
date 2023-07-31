package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NewsDto {
    private long id;
    private String title;
    private String description;
    private LocalDate publishDate;
}
