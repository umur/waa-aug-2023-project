package com.waa.project.dto.responseDto;

import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsersDto {
    private int id;
    private String email;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private LocalDateTime lastLogin;
    private int loginAttempt;
    @OneToOne
    private UserProfile profile;
}
