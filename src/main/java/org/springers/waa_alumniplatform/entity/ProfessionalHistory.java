package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class ProfessionalHistory {
    @Id @GeneratedValue
    private int id;
    private String position;
    @Column(name = "startDate")
    private LocalDate from; //SQL keyword
    @Column(name = "endDate") //SQL keyword
    private LocalDate to;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Company company;
}
