package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(nullable = false)
    private boolean isDeleted = false;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User applicant;

    private LocalDate applicationDate;

}
