package org.springers.waa_alumniplatform.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springers.waa_alumniplatform.entity.User;
import org.springers.waa_alumniplatform.exception.UnauthorizedException;
import org.springers.waa_alumniplatform.service.UserService;

import java.security.Principal;

@Aspect
@RequiredArgsConstructor
public class AuthorizationChecker {
    private final UserService userService;
    @Around("execution(* org.springers.waa_alumniplatform.service.impl.*.*(java.security.Principal, int, ..))")
    public Object verifyAuthorization(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Authorized checker aspect reached");
        Principal principal = (Principal) proceedingJoinPoint.getArgs()[0];
        int userId = (int) proceedingJoinPoint.getArgs()[1];
        boolean isAuthorized = isAuthorized(userId, principal);
        System.out.println("is authorized " + isAuthorized);
        if(isAuthorized) return proceedingJoinPoint.proceed();
        else {
            System.out.println(proceedingJoinPoint.getSignature().getName() + " blocked due to Unauthorized access");
            throw new UnauthorizedException("Unauthorized entity access");
        }
    }

    private boolean isAuthorized(int userId, Principal principal){
        User user = userService.getUserById(userId);
        return user.getEmail().equals(principal.getName());
    }
}
