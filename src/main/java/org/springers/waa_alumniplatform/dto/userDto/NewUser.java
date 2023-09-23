package org.springers.waa_alumniplatform.dto.userDto;

import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.enums.NewUserAccountType;

@Getter
@Setter
public class NewUser {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private NewUserAccountType accountType;
}
