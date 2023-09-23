package org.springers.waa_alumniplatform.dto.userDto;

import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.entity.Industry;
import org.springers.waa_alumniplatform.entity.Location;

@Setter
@Getter
public class FacultyProfile {
        private String firstName;
        private String lastName;
        private String profilePic;
        private String phoneNum;
        private String department;
        private Location location;
}
