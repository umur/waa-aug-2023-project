package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String venue;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private Alumni poster;
    @ManyToMany
    private List<Alumni> rsvpList;
    @ManyToMany
    private List<Alumni> attendees;
}

