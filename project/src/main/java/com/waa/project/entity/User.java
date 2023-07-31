package com.waa.project.entity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private LocalDateTime lastLogin;
    private int loginAttempt;

    @OneToOne
    private UserProfile profile;

    public void setPassword(String password) {
        this.password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public boolean checkPassword(String inputPassword) {
        return BCrypt.verifyer().verify(inputPassword.toCharArray(), this.password).verified;
    }

    public boolean canEditProfile(User editingUser) {
        if (editingUser.getUserRole() == UserRole.FACULTY || editingUser.getUserRole() == UserRole.ALUMNI) {
            // Check if the editingUser's ID matches the ID of the user whose profile is being edited
            return editingUser.getId() == this.getId();
        }

        if (editingUser.getUserRole() == UserRole.ADMIN) {
            return true;
        }

        return false; // Any other user role does not have permission to edit profiles
    }
}
