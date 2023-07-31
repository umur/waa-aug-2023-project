package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.authDto.LoginCredential;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;

public interface AuthService {
    Token register(NewUser newUser);

    Token authenticate(LoginCredential loginCredential);
}
