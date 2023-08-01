package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springframework.http.ResponseEntity;

public interface AlumniService {
    AlumniProfile getById(int alumniId);

    AlumniProfile updateById(int alumniId, AlumniProfile alumniProfile);
}
