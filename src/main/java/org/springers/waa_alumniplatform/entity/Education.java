package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.enums.EducationalLevel;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Education {
    @Id @GeneratedValue
    private int id;
    private String dept;
    private String major;
    private LocalDate admissionYear;
    private LocalDate gradYear;
    @OneToOne
    private University university;
    @Enumerated
    private EducationalLevel educationLevel;
}
