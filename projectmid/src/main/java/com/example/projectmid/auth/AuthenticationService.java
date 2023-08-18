package com.example.projectmid.auth;


import com.example.projectmid.Entities.User;
import com.example.projectmid.Repositories.UserRepository;
import com.example.projectmid.config.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .role(registerRequest.getRole())
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateJWTToken(user);

        return AuthenticationResponse
                .builder()
                .jwtToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()));

        User user = userRepository.findUserByUsername(authenticationRequest.getUserName());

        var jwtToken = jwtService.generateJWTToken(user);

        return AuthenticationResponse
                .builder()
                .jwtToken(jwtToken)
                .build();
    }
}
