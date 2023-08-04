package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.dto.userDto.AlumniPublic;
import org.springers.waa_alumniplatform.entity.Alumni;

import java.security.Principal;
import java.util.List;

public interface AlumniService {
    Alumni getAlumniById(int id);
    AlumniProfile getAlumniProfileById(int alumniId);

    AlumniProfile updateById(Principal principal, int alumniId, AlumniProfile alumniProfile);

    List<AlumniPublic> getAlumnusByGradYear(int year);

    List<AlumniPublic> getAlumnusByDept(String dept);

    List<AlumniPublic> getAlumnusByIndustry(String industry);
}
