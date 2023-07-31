package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User applicant;
    @ManyToOne
    private Job job;
    private LocalDate appliedDate;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
