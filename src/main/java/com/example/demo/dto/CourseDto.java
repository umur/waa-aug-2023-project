package com.example.demo.dto;

import com.example.demo.entity.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private long id;
    private String name;
    private Profile profile;
}
