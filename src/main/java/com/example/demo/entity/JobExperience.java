package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyName;
    private String position;
    private String startDate;
    private String endDate;
    private String description;
    private boolean isDeleted;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
