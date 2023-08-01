package com.waa.project.service.impl;

import com.waa.project.aspect.annotation.LogMe;
import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserProfile;
import com.waa.project.repository.UserProfileRepository;
import com.waa.project.service.JobExperienceService;
import com.waa.project.service.UserProfileService;
import com.waa.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    private JobExperienceService jobExperienceService;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    @LogMe
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @LogMe
    @Override
    public UserProfile getUserProfile(long id) {
        return userProfileRepository.findById(id).get();
    }

    @Override
    public List<UserProfile> getAllUserProfile() {
        return userProfileRepository.findAll();
    }

    @LogMe
    @Override
    public void addJobExperienceToUserProfile(long userProfileId, JobExperience jobExperience) {
        UserProfile userProfile = userProfileRepository.findById(userProfileId)
                .orElseThrow(() -> new IllegalArgumentException("User profile not found with ID: " + userProfileId));
        JobExperience jobExperience1 = jobExperienceService.createJobExperience(jobExperience);
        userProfile.addJobExperience(jobExperience1);
        userProfileRepository.save(userProfile);
    }


}
