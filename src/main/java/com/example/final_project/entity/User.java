package com.example.final_project.entity;

import com.example.final_project.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
//    @ManyToOne
//    private Address address;
//    @Embedded
//    private Profile profile;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
