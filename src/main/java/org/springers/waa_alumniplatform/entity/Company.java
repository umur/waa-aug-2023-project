package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Company {
    @Id @GeneratedValue
    private int id;
    private String name;
    @OneToOne
    private Location location;
}
