package com.example.final_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @JsonIgnore
    @ManyToOne
    private User commenter;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
