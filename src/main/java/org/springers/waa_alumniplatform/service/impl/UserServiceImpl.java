package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.repository.UserRepo;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public User getUserByEmail(String email){
        return userRepo.findUserByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User doesn't exisit"));
    }

    @Override
    public User persist(User user) {
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByEmail(username);
    }
}
