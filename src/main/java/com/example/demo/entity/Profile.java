package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Profile {
    @Id
    private int id;
    private String state;
    private String city;
    private Integer graduationYear;
    private String phone;
    private String email;
    private String profilePicture;


    // relationship with job experience

    // create a relationship with user
}
