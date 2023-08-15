package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "ALUMNI")
@SuperBuilder
@NoArgsConstructor
public class Alumni extends User{
    private String profilePic;
    private String phoneNum;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Industry industry;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;
    @OneToOne(cascade = CascadeType.ALL)
    private Education eduInOurUni;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Education> educationalHistory;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProfessionalHistory> professionalHistories;
}
