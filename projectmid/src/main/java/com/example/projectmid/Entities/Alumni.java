package com.example.projectmid.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int contactInformation;
    private String location;
    private String universityName;
    private String degree;
    private int graduationYear;
    private double gpa;
    private String jobTitle;
    private String award;

    @OneToOne(mappedBy = "alumni")
    private User user;
    @OneToMany(mappedBy = "alumni")
    private List<JobPortal> jobPortal;
    @OneToMany(mappedBy = "alumni")
    private List<Event> eventList;
    @OneToMany(mappedBy = "alumni")
    private List<Survey> surveyList;
    //
    @ManyToMany(mappedBy = "attendentList")
    private List<Event> events;
}
