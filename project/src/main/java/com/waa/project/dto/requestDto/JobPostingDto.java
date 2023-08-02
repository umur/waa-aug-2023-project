package com.waa.project.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostingDto {
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;
}
