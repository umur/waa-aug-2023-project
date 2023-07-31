package com.example.final_project.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
@Setter
@Getter
public class Profile {
    private String profilePic;
    private LocalDate gradYear;
    private String major;
    private int numExperience;
    private String achievement;
}
