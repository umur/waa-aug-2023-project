package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthenticationRequestDTO {
    private Integer id;
    @NotNull
    @Size(min=4,message="Username must be min of 4 characters")
    private String firstName;

    @Size(min=4,message="Username must be min of 4 characters")
    private String lastName;

    @Email(message="Email address is not Valid")
    private String email;
    @NotNull
    @Size(min=3, max=10 , message="Password must be min of 3 chars and mac=x of 10 chars")
    private String password;

    @Pattern(regexp = "^(student|admin|faculty)$", message = "Allowed values are 'student', 'admin' or 'faculty' in lowercase")
    @NotEmpty
    private String role;
}
