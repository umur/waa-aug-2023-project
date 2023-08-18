package com.waa.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private int phoneNumber;
    private Year graduationYear;
    private Year numberOfExperience;
    private String profilePicture;

    @OneToMany(fetch = FetchType.EAGER)
    private List<JobExperience> jobExperienceList;

    public void addJobExperience(JobExperience jobExperience) {
        if (jobExperienceList == null) {
            jobExperienceList = new ArrayList<>();
        }
        jobExperienceList.add(jobExperience);
    }
}
