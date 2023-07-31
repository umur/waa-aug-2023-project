package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int numRequired;
    private LocalDate postedOn;
    private LocalDate closingDate;
    @OneToMany(mappedBy = "job")
    private List<Applicant> applicantList;
    @ManyToOne
    private User jobPoster;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
