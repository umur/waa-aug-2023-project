package com.waa.project.dto.responseDto;

import com.waa.project.entity.UserProfile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private String email;
    private String password;
    private UserProfile profile;
}
