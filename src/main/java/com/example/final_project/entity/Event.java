package com.example.final_project.entity;

import com.example.final_project.enums.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@Enumerated(EnumType.ORDINAL)
    private EventType eventType;
    @JsonIgnore
    @OneToMany
    private List<User> attendees;
    @JsonIgnore
    @ManyToOne
    private User eventOrganizer;
    private LocalDate postedDate;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
