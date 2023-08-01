package com.example.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String industry;
    @ManyToOne
    private Student student;

    @ManyToMany
    private List<Student> appliedStudents;

    @Embedded
    private Address address;
}
