package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
//    private List<Review> reviews;
//    private Address address;
}
