package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.authDto.LoginCredential;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Faculty;
import org.springers.waa_alumniplatform.entity.User;

public interface AuthService {
    Token register(NewUser newUser);
    Faculty createFaculty(NewUser newUser);
    Alumni createAlumni(NewUser newUser);
    Token generateToken(User user);

    Token authenticate(LoginCredential loginCredential);
}
