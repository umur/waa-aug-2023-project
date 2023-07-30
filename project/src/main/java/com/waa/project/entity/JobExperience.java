package com.waa.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class JobExperience {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String companyName;
    private String potiosion;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isDeleted;
}
