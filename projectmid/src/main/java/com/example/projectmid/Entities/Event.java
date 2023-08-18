package com.example.projectmid.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "alumni_id")
//    private Alumni alumni;

//    @JsonManagedReference
//    @ManyToMany
//    private List<Alumni> attendentList;

}
