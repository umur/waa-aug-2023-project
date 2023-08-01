package com.example.demo.dto;

import com.example.demo.entity.RoleType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private RoleType role;
    private boolean isDeleted = false;
}
