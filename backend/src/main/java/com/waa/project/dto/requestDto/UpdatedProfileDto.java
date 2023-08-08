package com.waa.project.dto.requestDto;

import com.waa.project.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;

@Setter
@Getter
public class UpdatedProfileDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private int phoneNumber;
    private Year graduationYear;
    private Year numberOfExperience;
    private String profilePicture;
}
