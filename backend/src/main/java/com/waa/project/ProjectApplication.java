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
                SpringApplication.run(ProjectApplication.class,args);
    }
}
