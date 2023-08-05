package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.dto.userDto.FacultyProfile;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Faculty;
import org.springers.waa_alumniplatform.repository.FacultyRepo;
import org.springers.waa_alumniplatform.service.FacultyService;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final FacultyRepo facultyRepo;
    @Override
    public FacultyProfile getFacultyProfileById(int facultyId) {
        Faculty faculty = getFacultyById(facultyId);
        FacultyProfile facultyProfile = modelMapper.map(faculty, FacultyProfile.class);
        return facultyProfile;
    }



    @Override
    public FacultyProfile updateById(Principal principal, int facultyId, FacultyProfile facultyProfile) {
        Faculty faculty = getFacultyById(facultyId);

        faculty.setLocation(facultyProfile.getLocation());
        faculty.setPhoneNum(facultyProfile.getPhoneNum());
        faculty.setFirstName(facultyProfile.getFirstName());
        faculty.setLastName(facultyProfile.getLastName());
        faculty.setProfilePic(facultyProfile.getProfilePic());

        userService.persist(faculty);
        return facultyProfile;
    }

    public Faculty getFacultyById(int id){
        Faculty faculty = facultyRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Faculty with this Id doesn't exist"));
        return faculty;
    }
}
