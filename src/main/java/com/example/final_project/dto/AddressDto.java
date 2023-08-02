package com.example.final_project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto {
    private String zip;
    private String street;
    private String city;
    private String state;
}
