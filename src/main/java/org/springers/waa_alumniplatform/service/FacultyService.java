package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.userDto.FacultyProfile;

import java.security.Principal;

public interface FacultyService {
    FacultyProfile getFacultyProfileById(int facultyId);

    FacultyProfile updateById(Principal principal, int facultyId, FacultyProfile facultyProfile);
}
