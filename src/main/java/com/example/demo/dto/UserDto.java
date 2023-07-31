package com.example.demo.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    @Id
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
}
