package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value = "FACULTY")
@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
public class Faculty extends User{
    private String firstName;
    private String lastName;
    private String profilePic;
    private String phoneNum;
    private String department;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;
}
