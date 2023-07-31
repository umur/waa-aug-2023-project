package com.waa.project.entity;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private LocalDateTime lastLogin;
    private int loginAttempt;
    @OneToOne(cascade = CascadeType.ALL)
    private UserProfile profile;
//    public void setPassword(String password) {
//        this.password = BCrypt.withDefaults().hashToString(12,password.toCharArray());
//    }
//    public boolean checkPassword(String inputPassword) {
//        return BCrypt.verifyer().verify(inputPassword.toCharArray(),this.password).verified;
//    }

//    public boolean canEditProfile(User editingUser) {
//
//        if (editingUser.getUserRole() == UserRole.FACULTY || editingUser.getUserRole() == UserRole.ALUMNI) {
//            // Check if the editingUser's ID matches the ID of the user whose profile is being edited
//            return editingUser.getId() == this.getId();
//        }
//
//        if (editingUser.getUserRole() == UserRole.ADMIN) {
//            return true;
//        }
//
//        return false; // Any other user role does not have permission to edit profiles
//    }

    public UserProfile getProfile() {
        return profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(this.userRole.name()));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
