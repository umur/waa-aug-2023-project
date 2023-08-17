package com.waa.project.dto.responseDto;

import com.waa.project.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String accessToken;
    private UserRole role;
}
