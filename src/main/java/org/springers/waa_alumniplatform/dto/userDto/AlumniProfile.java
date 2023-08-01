package org.springers.waa_alumniplatform.dto.userDto;


import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.entity.Education;
import org.springers.waa_alumniplatform.entity.Industry;
import org.springers.waa_alumniplatform.entity.Location;
import org.springers.waa_alumniplatform.entity.ProfessionalHistory;

import java.util.List;

@Setter
@Getter
public class AlumniProfile {
    private String firstName;
    private String lastName;
    private String profilePic;
    private String phoneNum;
    private Industry industry;
    private Location location;
    private Education eduInOurUni;
    private List<Education> educationalHistory;
    private List<ProfessionalHistory> professionalHistories;
}
