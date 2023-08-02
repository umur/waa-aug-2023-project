package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String responsibilities;
    private LocalDate startDate;
    private LocalDate endDate;
    private String organization;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
