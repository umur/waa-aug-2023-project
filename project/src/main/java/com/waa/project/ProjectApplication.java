package com.waa.project;

import com.waa.project.entity.Gender;
import com.waa.project.entity.User;
import com.waa.project.entity.UserProfile;
import com.waa.project.entity.UserRole;
import com.waa.project.repository.UserProfileRepository;
import com.waa.project.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ProjectApplication.class);

        // Set up default data
        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
        UserProfileRepository userProfileRepository = configurableApplicationContext.getBean(UserProfileRepository.class);

        // Create a new UserProfile instance and fill the data
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("John");
        userProfile.setLastName("Doe");
        userProfile.setDateOfBirth(LocalDate.of(1990, 5, 15));
        userProfile.setGender(Gender.Male);
        userProfile.setAddress("123 Main Street");
        userProfile.setPhoneNumber(123456789);
        userProfile.setGraduationYear(Year.of(2015));
        userProfile.setNumberOfExperience(Year.of(6));
        userProfile.setProfilePicture("R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");

        // Save the UserProfile to the database using UserProfileRepository (if you have one)
        userProfileRepository.save(userProfile);

        // Create a new User instance and fill the data
        User user = new User();
        user.setEmail("user@example.com");
        user.setPassword("password123");
        user.setUserRole(UserRole.ALUMNI);
        user.setActive(true);
        user.setLastLogin(LocalDateTime.now());
        user.setLoginAttempt(0);

        // Associate the saved UserProfile with the User
        user.setProfile(userProfile);

        // Save the User to the database using UserRepository
        userRepository.save(user);


        System.out.println(userRepository.findAll());

        // Verify password
        System.out.println(user.checkPassword("password123"));
    }

}
