package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User postedBy;

    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private List<JobApplication> jobApplications;
}
