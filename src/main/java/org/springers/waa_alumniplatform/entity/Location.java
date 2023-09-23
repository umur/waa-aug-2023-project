package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id @GeneratedValue
    private int id;
    private String street;
    private int zipcode;
    private String state;
    private String city;
}
