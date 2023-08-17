package com.example.springproject.entity;

import java.util.List;

import com.example.springproject.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private int id;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String companyName;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String industry;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(Views.JobControllerView.class)
    private Student student;

    @ManyToMany
    @JsonView(Views.JobControllerView.class)

    private List<Student> appliedStudents;

    @Embedded
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private Address address;
}
