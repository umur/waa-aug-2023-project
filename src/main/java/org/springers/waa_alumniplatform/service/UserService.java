package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUserByEmail(String email);

    User persist(User user);
}
