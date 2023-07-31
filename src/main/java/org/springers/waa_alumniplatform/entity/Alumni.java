package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    private Industry industry;
    @OneToOne
    private Location location;
    @OneToOne
    private Education eduInOurUni;
    @OneToMany
    private List<Education> educationalHistory;
    @OneToMany
    private List<ProfessionalHistory> professionalHistories;

}
