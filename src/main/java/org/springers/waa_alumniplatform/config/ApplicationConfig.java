package org.springers.waa_alumniplatform.config;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springers.waa_alumniplatform.aspect.AllUserActivityLogger;
import org.springers.waa_alumniplatform.aspect.AuthorizationChecker;
import org.springers.waa_alumniplatform.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@RequiredArgsConstructor
@EnableAspectJAutoProxy
public class ApplicationConfig {
    private final UserService userService;
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public AllUserActivityLogger allUserActivityLogger(){
        return new AllUserActivityLogger();
    }

    @Bean
    public AuthorizationChecker authorizationChecker(){
        return new AuthorizationChecker(userService);
    }
}
