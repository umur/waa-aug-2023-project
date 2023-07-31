package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate postedOn;
    @ManyToOne
    private User newsPoster;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
