package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String profilePic;
    private LocalDate gradYear;
    private String major;
    private int numExperience;
    private String achievement;
    @OneToOne(mappedBy = "profile")
    private User user;
    //@Column(name = "deleted", nullable = false)
}
