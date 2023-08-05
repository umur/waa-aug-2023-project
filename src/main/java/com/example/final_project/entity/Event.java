package com.example.final_project.entity;

import com.example.final_project.enums.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EventType eventType;
    @OneToMany
    private List<User> attendees;
    @ManyToOne
    private User eventOrganizer;
    private LocalDate postedDate;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
