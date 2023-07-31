package com.example.demo.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDto {
    @Id
    private long id;
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;

    //TODO Add relationship with alumni or user with alumni_id
}
