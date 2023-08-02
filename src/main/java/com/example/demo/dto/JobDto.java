package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDto {
    @Id
    private long id;
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 50, message = "Title must be between 5 and 50 characters")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Company name is required")
    @Size(min = 5, max = 50, message = "Company name must be between 5 and 50 characters")
    private String companyName;
    private User user;
    private boolean isDeleted = false;
}
