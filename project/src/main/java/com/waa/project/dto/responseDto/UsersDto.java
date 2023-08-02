package com.waa.project.dto.responseDto;

import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDto {
    private Long id;
    private String email;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private LocalDateTime lastLogin;
    private int loginAttempt;
    private UserProfile profile;
    public static UsersDto fromUser(User user){
        return  new UsersDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUserRole(),
                user.isActive(),
                user.getLastLogin(),
                user.getLoginAttempt(),
                user.getProfile());
    }
}
