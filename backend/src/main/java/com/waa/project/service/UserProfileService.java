package com.waa.project.service;

import com.waa.project.dto.requestDto.UpdatedProfileDto;
import com.waa.project.entity.JobExperience;
import com.waa.project.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    public void addJobExperienceToUserProfile(long userProfileId, JobExperience jobExperience);
    public UserProfile createUserProfile(UserProfile userProfile);
    UserProfile getUserProfile(long id);
    List<UserProfile> getAllUserProfile();
    void updateUserProfile(Long id, UpdatedProfileDto updatedProfileDto);
}
