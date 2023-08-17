package com.example.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.example.springproject.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Getter
@Setter
//@DiscriminatorColumn(name = "item_type")
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private int id;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String firstName;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String lastName;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String email;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String graduationYear;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String description;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String category;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private String industry;
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})
    @Embedded
    private Address address;

    @ElementCollection
    @JsonView({Views.JobControllerView.class, Views.StudentControllerView.class})

    private   List<String> courses;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonView(Views.StudentControllerView.class)
    private List<Job> jobs;
}

