package org.springers.waa_alumniplatform.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springers.waa_alumniplatform.dto.userDto.AlumniProfile;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.repository.AlumniRepo;
import org.springers.waa_alumniplatform.repository.UserRepo;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {
    private final ModelMapper modelMapper;
    private final AlumniRepo alumniRepo;
    private final UserRepo userRepo;
    @Override
    public AlumniProfile getById(int alumniId) {
        Alumni alumni = getAlumniById(alumniId);
        AlumniProfile alumniProfile = modelMapper.map(alumni, AlumniProfile.class);
        return alumniProfile;
    }

    @Override
    public AlumniProfile updateById(int alumniId, AlumniProfile alumniProfile) {
        Alumni alumni = getAlumniById(alumniId);

        alumni.setIndustry(alumniProfile.getIndustry());
        alumni.setLocation(alumniProfile.getLocation());
        alumni.setEducationalHistory(alumniProfile.getEducationalHistory());
        alumni.setEduInOurUni(alumniProfile.getEduInOurUni());
        alumni.setPhoneNum(alumni.getPhoneNum());
        alumni.setProfessionalHistories(alumniProfile.getProfessionalHistories());
        alumni.setFirstName(alumniProfile.getFirstName());
        alumni.setLastName(alumniProfile.getLastName());
        alumni.setProfilePic(alumniProfile.getProfilePic());

        userRepo.save(alumni);
        return alumniProfile;
    }

    private Alumni getAlumniById(int id){
        Alumni alumni = alumniRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Alumni with this Id doesn't exist"));
        return alumni;
    }
}
