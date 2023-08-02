package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate date;
    private String location;
    private boolean isDeleted;

    @JsonBackReference
    @ManyToOne
    private User organizer;

    @OneToMany(mappedBy = "event")
    private List<User> participants;

    @OneToMany(mappedBy = "event")
    private List<EventParticipant> participantsList;

}
