package com.example.final_project.aspect;

import com.example.final_project.entity.User;
import com.example.final_project.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private static final Logger logger = LogManager.getLogger(User.class.getName());
    @AfterThrowing(pointcut = "execution(* com.example.final_project.impl.UserServiceImpl.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex){
        LocalDateTime time = LocalDateTime.now();
        String className = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
       logger.error("Exception in " + className + " method " + method + " at " + time);
    }

}
