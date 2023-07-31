package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Job {
    @Id
    private int id;
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;

    //TODO Add relationship with alumni or user with alumni_id
}
