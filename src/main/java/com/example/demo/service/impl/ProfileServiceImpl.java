package com.example.demo.service.impl;

import com.example.demo.dto.ProfileDto;
import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepo profileRepo;
    private final ModelMapper modelMapper;
    @Override
    public ProfileDto save(ProfileDto profileDto) {
        Profile profile = modelMapper.map(profileDto, Profile.class);
        Profile newProfile = profileRepo.save(profile);
        return modelMapper.map(newProfile, ProfileDto.class);
    }

    @Override
    public List<ProfileDto> getAll() {
        List<Profile> profileList = profileRepo.findAll();
        return profileList.stream().map(profile ->
                modelMapper.map(profile, ProfileDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProfileDto getById(long id) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if(profileOptional.isEmpty()){
            return null;
        }
        Profile profile = profileOptional.get();
        return modelMapper.map(profile, ProfileDto.class);
    }

    @Override
    public ProfileDto update(ProfileDto profileDto, long id) {
        if(!profileRepo.existsById(id)){
            return null;
        }
        ProfileDto entityDto = getById(id);
        Profile profile = modelMapper.map(entityDto, Profile.class);
        if(profileDto.getState() != null) profile.setState(profileDto.getState());
        if(profileDto.getCity() != null) profile.setCity(profileDto.getCity());
        if(profileDto.getGraduationYear() != null) profile.setGraduationYear(profileDto.getGraduationYear());
        if(profileDto.getPhone() != null) profile.setPhone(profileDto.getPhone());
        if(profileDto.getEmail() != null) profile.setEmail(profileDto.getEmail());
        if(profileDto.getProfilePicture() != null) profile.setProfilePicture(profileDto.getProfilePicture());

        Profile updatedProfile = profileRepo.save(profile);
        return modelMapper.map(updatedProfile, ProfileDto.class);
    }

    @Override
    public boolean delete(long id) {

        Optional<Profile> profileOptional = profileRepo.findById(id);
        if(profileOptional.isEmpty()){
            return false;
        }
        Profile profile = profileOptional.get();
        profile.setDeleted(true);
        profileRepo.save(profile);
        return true;
    }

    @Override
    public List<ProfileDto> getProfilesByGraduationYear(Integer graduationYear) {
        List<Profile> profileList = profileRepo.findByGraduationYear(graduationYear);
        return profileList.stream().map(profile ->
                modelMapper.map(profile, ProfileDto.class)).collect(Collectors.toList());
    }
}
