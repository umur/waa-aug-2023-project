package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserProfile;
import com.waa.project.repository.UserProfileRepository;
import com.waa.project.service.JobExperienceService;
import com.waa.project.service.UserProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;
    @Autowired
    private JobExperienceService jobExperienceService;
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    @Override
    public UserProfile getUserProfile(long id) {
        return userProfileRepository.findById(id).get();
    }
    @Override
    public List<UserProfile> getAllUserProfile() {
        return userProfileRepository.findAll();
    }
    @Override
    public void addJobExperienceToUserProfile(long userProfileId, JobExperience jobExperience) {
        UserProfile userProfile = userProfileRepository.findById(userProfileId)
                .orElseThrow(() -> new IllegalArgumentException("User profile not found with ID: " + userProfileId));
        JobExperience jobExperience1 = jobExperienceService.createJobExperience(jobExperience);
        userProfile.addJobExperience(jobExperience1);
        userProfileRepository.save(userProfile);
    }
    @Override
    public void updateUserProfile(Long id,UpdatedProfileDto updatedProfileDto) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
        if (userProfileOptional.isPresent()) {
            UserProfile userProfile = userProfileOptional.get();
            userProfile.setGender(updatedProfileDto.getGender());
            userProfile.setFirstName(updatedProfileDto.getFirstName());
            userProfile.setLastName(updatedProfileDto.getLastName());
            userProfile.setDateOfBirth(updatedProfileDto.getDateOfBirth());
            userProfile.setAddress(updatedProfileDto.getAddress());
            userProfile.setPhoneNumber(updatedProfileDto.getPhoneNumber());
            userProfile.setGraduationYear(updatedProfileDto.getGraduationYear());
            userProfile.setNumberOfExperience(updatedProfileDto.getNumberOfExperience());
            userProfile.setProfilePicture(updatedProfileDto.getProfilePicture());
            userProfileRepository.save(userProfile);
        } else {
            throw new EntityNotFoundException("User profile not found with ID: " + id);
        }
    }
}
