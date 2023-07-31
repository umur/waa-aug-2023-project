package com.example.final_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Embeddable
@Setter
@Getter
public class Profile {
    private String profilePic;
    private LocalDate gradYear;
    private String major;
    private int numExperience;
    private String achievement;
    @OneToMany
    private List<Experience> experienceList;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
