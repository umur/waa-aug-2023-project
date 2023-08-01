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
    private LocalDate from;
    private LocalDate to;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
}
