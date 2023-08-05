package com.example.final_project.dto;

import com.example.final_project.entity.Experience;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private String profilePic;
    private LocalDate gradYear;
    private String major;
    private int numExperience;
    private String achievement;
    private List<Experience> experienceList;
}
