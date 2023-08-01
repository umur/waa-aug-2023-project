package com.example.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
//@DiscriminatorColumn(name = "item_type")
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String graduationYear;
    private String description;
    private String category;
    private String industry;
    @Embedded
    private Address address;

    @ElementCollection
    private   List<String> courses;


    @OneToMany(mappedBy = "student")
    private List<Job> jobs;
}

/*
 one to many
 many to many
 ---------------------

 */