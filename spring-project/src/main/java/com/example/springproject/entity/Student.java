package com.example.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String description;
    private String category;

    @OneToOne
//    @JoinColumn(name = "student_id")
    private Address address;
}

/*
 one to many
 many to many
 ---------------------

 */