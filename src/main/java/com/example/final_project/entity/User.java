package com.example.final_project.entity;

import com.example.final_project.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
@Service
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    private Address address;
    @OneToOne
    private Profile profile;
    @Column(name = "deleted", nullable = true)
    private boolean deleted = false;
}
