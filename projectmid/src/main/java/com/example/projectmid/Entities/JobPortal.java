package com.example.projectmid.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class JobPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String company;
    private String jobDescription;
    private LocalDate deadLine;
    private String city;
    private String state;
    /*
    One User can be a Job Seeker and apply for multiple Job Postings (one-to-many relationship).
    One Job Posting can have multiple Job Seekers applying (one-to-many relationship).*/
    //comment: add job seeker so that he can apply for the jobs.
    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;

}
