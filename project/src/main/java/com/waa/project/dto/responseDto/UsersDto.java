package com.waa.project.dto.responseDto;

import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UsersDto {
    private int id;
    private String email;
    private UserRole userRole;
    private UserProfile profile;


    public static UsersDto fromUser(User user){
        return  new UsersDto(user.getId(), user.getEmail(), user.getUserRole(), user.getProfile());
    }
}
