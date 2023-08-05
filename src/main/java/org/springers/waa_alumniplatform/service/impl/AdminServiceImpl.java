package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.authDto.Password;
import org.springers.waa_alumniplatform.dto.authDto.Token;
import org.springers.waa_alumniplatform.dto.userDto.NewUser;
import org.springers.waa_alumniplatform.entity.Admin;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.enums.AccountStatus;
import org.springers.waa_alumniplatform.enums.NewUserAccountType;
import org.springers.waa_alumniplatform.enums.Role;
import org.springers.waa_alumniplatform.exception.BadRequestException;
import org.springers.waa_alumniplatform.repository.AdminRepo;
import org.springers.waa_alumniplatform.service.AdminService;
import org.springers.waa_alumniplatform.service.AuthService;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final AdminRepo adminRepo;
    @Override
    public Token createUser(NewUser newUser) {
        authService.ensureEmailIsUnique(newUser.getEmail());
        User user;
        if (newUser.getAccountType() == NewUserAccountType.ALUMNI) user = authService.createAlumni(newUser);
        else if(newUser.getAccountType() == NewUserAccountType.FACULTY) user = authService.createFaculty(newUser);
        else if(newUser.getAccountType() == NewUserAccountType.ADMIN) user = createAdmin(newUser);
        else throw new BadRequestException("Can't create account of type " + newUser.getAccountType().name());
        user.setAccountNonLocked(true);
        userService.persist(user);
        return authService.generateToken(user);
    }

    @Override
    public Admin getById(int adminId) {
        Admin admin = adminRepo
                .findById(adminId)
                .orElseThrow(() -> new UsernameNotFoundException("Admin doesn't exist"));
        return admin;
    }

    @Override
    public User activateDeactivateUser(int userId) {
        User user = userService.getUserById(userId);
        if(user.getAccountStatus() == AccountStatus.ACTIVE) user.setAccountStatus(AccountStatus.DEACTIVATED);
        else user.setAccountStatus(AccountStatus.ACTIVE);
        return userService.persist(user);
    }

    @Override
    public User resetUserPassword(Password password, int userId) {
        User user = userService.getUserById(userId);
        user.setPassword(
                bCryptPasswordEncoder.encode(password.getPassword())
        );
        return userService.persist(user);
    }

    private Admin createAdmin(NewUser newUser) {
        return Admin.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(bCryptPasswordEncoder.encode(newUser.getPassword()))
                .accountStatus(AccountStatus.ACTIVE)
                .role(Role.ADMIN)
                .build();
    }
}
