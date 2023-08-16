package com.example.demo.dto;

import com.example.demo.entity.JobExperience;
import com.example.demo.entity.User;
import com.example.demo.entity.Profile;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProfileDto {
    @Id
    private long id;
    @NotBlank(message = "State is required")
    @Size(min = 2, max = 30, message = "State must be between 2 and 30 characters")
    private String state;
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 30, message = "City must be between 2 and 30 characters")
    private String city;
    @NotBlank(message = "Graduation year is required")
    private Integer graduationYear;
    private String phone;
    @NotBlank(message = "Email is required")
    private String email;
    private String profilePicture;
    private boolean isDeleted = false;
    private List<JobExperience> jobExperiences;
    private User user;
    private Profile profile;
}
