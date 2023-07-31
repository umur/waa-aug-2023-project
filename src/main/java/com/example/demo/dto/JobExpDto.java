package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobExpDto {
    private int id;
    private String companyName;
    private String position;
    private String startDate;
    private String endDate;
    private String description;
}
