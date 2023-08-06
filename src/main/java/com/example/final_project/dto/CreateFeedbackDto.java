package com.example.final_project.dto;

import com.example.final_project.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFeedbackDto {
    private String comment;
    private User commenter;
}
