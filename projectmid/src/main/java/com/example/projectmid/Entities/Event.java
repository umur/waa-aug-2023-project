package com.example.projectmid.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity

@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;
    @ManyToMany
    private List<Alumni> attendentList;

}
