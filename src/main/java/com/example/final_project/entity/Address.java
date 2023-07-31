package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int zip;
    private String street;
    private String city;
    private String state;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
