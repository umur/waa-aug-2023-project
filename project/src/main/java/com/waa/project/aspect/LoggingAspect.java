package com.waa.project.aspect;

import com.waa.project.dto.requestDto.SystemLogRequestDto;
import com.waa.project.entity.LogLevel;
import com.waa.project.entity.UserProfile;
import com.waa.project.service.JwtTokenService;
import com.waa.project.service.SystemLogService;
import com.waa.project.service.UserService;
import com.waa.project.util.LoggingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggingAspect {
//    private final UserDetails userDetails;
    private final SystemLogService systemLogService;
    private final UserService userService;
    @After("@annotation(com.waa.project.aspect.annotation.LogMe)")
    public void log(JoinPoint joinPoint){
        LoggingUtil.logMessage("Method Excution: " + joinPoint.getSignature().getName());
        SystemLogRequestDto systemLogRequestDto = new SystemLogRequestDto();
        systemLogRequestDto.setLogLevel(LogLevel.CAUSUAL);
        systemLogRequestDto.setLogMessage(joinPoint.getSignature().getName());
        systemLogService.addSystemLog(systemLogRequestDto);
        LoggingUtil.logMessage("Activity: " + systemLogService.getSystemLogs());
//        LoggingUtil.logMessage("User Id: " + userService.findByEmail(userDetails.getUsername()).getId());
    }
}
