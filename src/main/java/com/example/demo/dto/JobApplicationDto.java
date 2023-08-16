package com.example.demo.dto;

import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class JobApplicationDto {
    private long id;
    private Job job;
    private User applicant;
    private LocalDate applicationDate;
    private boolean isDeleted;
}
