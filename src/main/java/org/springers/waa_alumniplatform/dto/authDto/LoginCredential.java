package org.springers.waa_alumniplatform.dto.authDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCredential {
    private String email;
    private String password;
}
