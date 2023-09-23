package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value = "ADMIN")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User{
}
