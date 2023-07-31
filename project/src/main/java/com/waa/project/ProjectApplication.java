package com.waa.project;

import com.waa.project.entity.*;
import com.waa.project.repository.UserRepository;
import com.waa.project.service.JwtTokenService;
import com.waa.project.service.UserService;
import com.waa.project.service.UserProfileService;
import com.waa.project.service.JobExperienceService;
import com.waa.project.util.LoggingUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProjectApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ProjectApplication.class);

//        // Set up default data
//        UserService userService = configurableApplicationContext.getBean(UserService.class);
//        UserProfileService userProfileService = configurableApplicationContext.getBean(UserProfileService.class);
//        JobExperienceService jobExperienceService = configurableApplicationContext.getBean(JobExperienceService.class);
//        JwtTokenService jwtTokenService = configurableApplicationContext.getBean(JwtTokenService.class);
//
//        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
//
//        // Create a new UserProfile instance and fill the data
//        UserProfile userProfile = new UserProfile();
//        userProfile.setFirstName("John");
//        userProfile.setLastName("Doe");
//        userProfile.setDateOfBirth(LocalDate.of(1990, 5, 15));
//        userProfile.setGender(Gender.Male);
//        userProfile.setAddress("123 Main Street");
//        userProfile.setPhoneNumber(123456789);
//        userProfile.setGraduationYear(Year.of(2015));
//        userProfile.setNumberOfExperience(Year.of(6));
//        userProfile.setProfilePicture("R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");
//
//        // Save the UserProfile to the database using UserProfileService
//        userProfileService.createUserProfile(userProfile);
//
//        // Create a new User instance and fill the data
//        User user = new User();
//        user.setEmail("user@example.com");
//        user.setPassword("$2a$10$5qhC24LMRf3EB1n1s1Esw.Q2SNcy5KXpWk6GVXBR7EosBqpEKyy1i");
//        user.setUserRole(UserRole.ALUMNI);
//        user.setActive(true);
//        user.setLastLogin(LocalDateTime.now());
//        user.setLoginAttempt(0);
//
//        // Associate the saved UserProfile with the User
//        user.setProfile(userProfile);
//
//        // Save the User to the database using UserService
//        userService.createUser(user);
//
//        // Create a new JobExperience instance and fill the data
//        JobExperience jobExperience = new JobExperience();
//        jobExperience.setCompanyName("ABC Company");
//        jobExperience.setPosition("Software Developer");
//        jobExperience.setStartDate(LocalDate.of(2017, 1, 1));
//        jobExperience.setEndDate(LocalDate.of(2019, 12, 31));
//        jobExperience.setDeleted(false);
//
//        // Save the JobExperience to the database using JobExperienceService
//        jobExperienceService.createJobExperience(jobExperience);
//
//        // Associate the saved JobExperience with the UserProfile using UserProfileService
//        userProfileService.addJobExperienceToUserProfile(userProfile.getId(), jobExperience);
//
//        // Get List user
//        LoggingUtil.logMessage("get All: " + userRepository.findAll());
//
//        // Generate Token
//        LoggingUtil.logMessage("Generate Token: " + jwtTokenService.generateToken(user));
//
//        // find username by id
//        LoggingUtil.logMessage("User Id: " + userRepository.findByEmail("user@example.com").get().getId());
    }
}
