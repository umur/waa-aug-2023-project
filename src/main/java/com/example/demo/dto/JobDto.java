package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDto {
    @Id
    private long id;
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;
    private User user;
    private boolean isDeleted = false;
}
