package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String state;
    private String city;
    private Integer graduationYear;
    private String phone;
    private String email;
    private String profilePicture;


    @OneToMany(mappedBy = "profile")
    private List<JobExperience> jobExperiences;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
