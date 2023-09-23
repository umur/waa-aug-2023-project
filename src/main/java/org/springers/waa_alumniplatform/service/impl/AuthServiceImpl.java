package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.authDto.LoginCredential;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Faculty;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.enums.AccountStatus;
import org.springers.waa_alumniplatform.enums.NewUserAccountType;
import org.springers.waa_alumniplatform.enums.Role;
import org.springers.waa_alumniplatform.exception.BadRequestException;
import org.springers.waa_alumniplatform.service.AuthService;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Token register(NewUser newUser) {
        ensureEmailIsUnique(newUser.getEmail());
        User user;
        if (newUser.getAccountType() == NewUserAccountType.ALUMNI) user = createAlumni(newUser);
        else if(newUser.getAccountType() == NewUserAccountType.FACULTY) user = createFaculty(newUser);
        else throw new BadRequestException("Can't create account of type " + newUser.getAccountType().name());
        user.setAccountNonLocked(true);
        userService.persist(user);
        return this.generateToken(user);
    }

    @Override
    public Token authenticate(LoginCredential loginCredential) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginCredential.getEmail(),
                loginCredential.getPassword()
        ));
        User user = userService.getUserByEmail(loginCredential.getEmail());
        return generateToken(user);
    }

    public void ensureEmailIsUnique(String email){
        if(userService.isEmailAreadyInUse(email)) throw new BadCredentialsException("Email already in use");
    }


    public Token generateToken(User user) {
        return Token.builder()
                .token(jwtService.generateToken(user))
                .id(user.getId())
                .name(user.getFirstName())
                .build();
    }

    public Alumni createAlumni(NewUser newUser) {
        return Alumni.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(bCryptPasswordEncoder.encode(newUser.getPassword()))
                .accountStatus(AccountStatus.ACTIVE)
                .role(Role.ALUMNI)
                .build();
    }

    public Faculty createFaculty(NewUser newUser){
        System.out.println("create Faculty called with password " + newUser.getPassword());
        return Faculty.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(bCryptPasswordEncoder.encode(newUser.getPassword()))
                .accountStatus(AccountStatus.ACTIVE)
                .role(Role.FACULTY)
                .build();
    }


}
