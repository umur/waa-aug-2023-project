package com.waa.project.aspect;

import com.waa.project.entity.User;
import com.waa.project.util.LoggingUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActiveAspect {

    @AfterReturning(pointcut = "@annotation(com.waa.project.aspect.annotation.CheckUserActive)", returning = "result")
    public ResponseEntity<?> checkUserActiveResponse(ResponseEntity<?> result) {
        boolean isActive = getCurrentActiveStatus();
        LoggingUtil.logMessage("status: "+isActive);
        if (!isActive) {
            throw new RuntimeException("User is inactive " + isActive);
        }
        return result;
    }

    private boolean getCurrentActiveStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User currentUser = (User) authentication.getPrincipal();
            return currentUser.isActive();
        }
        return false;
    }
}
