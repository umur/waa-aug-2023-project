package com.example.demo.dto;

import com.example.demo.entity.JobExperience;
import com.example.demo.entity.User;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProfileDto {
    @Id
    private long id;
    private String state;
    private String city;
    private Integer graduationYear;
    private String phone;
    private String email;
    private String profilePicture;
    private boolean isDeleted = false;
    private List<JobExperience> jobExperiences;
    private User user;
}
