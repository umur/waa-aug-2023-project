package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate applicationDate;
    @Column(nullable = false)
    private boolean isDeleted = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User applicant;

}
