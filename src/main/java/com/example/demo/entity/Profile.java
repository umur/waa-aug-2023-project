package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;


@Entity
@Setter
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String state;
    private String city;
    private Integer graduationYear;
    private String phone;
    private String email;
    private String profilePicture;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "profile")
    private List<JobExperience> jobExperiences;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
