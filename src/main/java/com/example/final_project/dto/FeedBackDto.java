package com.example.final_project.dto;

import com.example.final_project.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedBackDto {
    private Long id;
    private String comment;
    private User commenter;
    private boolean deleted = false;

}
