package com.example.demo.dto;

import com.example.demo.entity.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobExpDto {
    private long id;
    @NotBlank(message = "Company name is required")
    @Size(min = 2, max = 30, message = "Company name must be between 2 and 30 characters")
    private String companyName;
    @NotBlank(message = "Position is required")
    private String position;
    @NotBlank(message = "Start date is required")
    private String startDate;
    @NotBlank(message = "End date is required")
    private String endDate;
    private String description;
    @NotBlank(message = "Profile is required")
    private Profile profile;
    private boolean isDeleted;
}
