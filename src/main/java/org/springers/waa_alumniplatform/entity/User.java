package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.enums.AccountStatus;
import org.springers.waa_alumniplatform.enums.Role;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userType")
public abstract class User {
    @Id @GeneratedValue
    private int id;
    private String email;
    private String password;
    @Enumerated
    private AccountStatus accountStatus;
    @Enumerated
    private Role role;
}
