package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue(value = "FACULTY")
@SuperBuilder
@NoArgsConstructor
public class Faculty extends User{
}
