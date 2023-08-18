package com.example.projectmid.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
public class Alumni implements Serializable {
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

    @JsonManagedReference
    @OneToMany(mappedBy = "alumni")
    private List<JobPortal> jobPortal;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "alumni")
//    private List<Event> eventList;

    @JsonManagedReference
    @OneToMany(mappedBy = "alumni")
    private List<Survey> surveyList;

//    @JsonBackReference
//    @ManyToMany(mappedBy = "attendentList")
//    private List<Event> events;
}
