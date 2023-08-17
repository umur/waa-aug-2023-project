package com.example.springproject.Aspect;

import com.example.springproject.entity.Log;
import com.example.springproject.entity.User;
import com.example.springproject.repository.UserRepo;
import com.example.springproject.service.UserService;
import com.example.springproject.Aspect.LogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Aspect
@Configuration
@Component
@RequiredArgsConstructor
public class UserActivityLogger {

   private final LogService logger;


    private final UserRepo userRepo;


    @After("execution(* com.example.springproject.service.*.*(..))")
    public void log(JoinPoint joinPoint) {
        var log = new Log();
        log.setTime(LocalDateTime.now());
        log.setDescription(joinPoint.toShortString());
        SimpleGrantedAuthority userId = null;
        try{
            userId = (SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1];
            User userInDB;
            if (userRepo.findById(Long.valueOf(userId.getAuthority())).isPresent()) {
                userInDB = userRepo.findById(Long.valueOf(userId.getAuthority())).get();
            } else {
                userInDB = null;
            }

            log.setUser(userInDB);
            logger.addLog(log);
        }catch (Exception e){
            userId = (SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0];
        }
    }
}
