package com.waa.project.dto.responseDto;

import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    private String email;
    private String password;
    private UserRole role;
    private UserProfile profile;
}
