package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FACULTY")
public class Faculty extends User{
}
