package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;
    @Column(nullable = false)
    private boolean isDeleted = false;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
