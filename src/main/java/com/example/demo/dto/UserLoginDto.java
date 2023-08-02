package com.example.demo.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserLoginDto {
    @Email(message="Email address is not Valid")
    private String email;
    private String password;
}
