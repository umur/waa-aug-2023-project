package com.example.final_project.security;

import com.example.final_project.entity.User;
import com.example.final_project.exception.UserNotFoundException;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
       User user = userRepository.findUserByEmailAndDeletedEquals(username, false)
                .orElseThrow( () ->new UserNotFoundException("user not found"));
        return new CustomUserDetails(user);
    }
}
