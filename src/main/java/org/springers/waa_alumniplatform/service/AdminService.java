package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.authDto.Password;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Admin;
import org.springers.waa_alumniplatform.entity.User;

public interface AdminService {
    Token createUser(NewUser newUser);

    Admin getById(int adminId);

    User activateDeactivateUser(int userId);

    User resetUserPassword(Password password, int userId);
}
