package com.waa.project.aspect;

import com.waa.project.dto.requestDto.SystemLogRequestDto;
import com.waa.project.entity.LogLevel;
import com.waa.project.service.AuthenticationService;
import com.waa.project.service.SystemLogService;
import com.waa.project.util.LoggingUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggingAspect {
    private final SystemLogService systemLogService;
    private final AuthenticationService authenticationService;
    @After("@annotation(com.waa.project.aspect.annotation.LogMe)")
    public void log(JoinPoint joinPoint){
        LoggingUtil.logMessage("Method Excution: " + joinPoint.getSignature().getName());
        SystemLogRequestDto systemLogRequestDto = new SystemLogRequestDto();
        systemLogRequestDto.setLogLevel(LogLevel.CAUSUAL);
        systemLogRequestDto.setLogMessage(joinPoint.getSignature().getName());
        Long id = authenticationService.getCurrentUserId();
        systemLogService.addSystemLog(systemLogRequestDto,id);
        LoggingUtil.logMessage("Activity: " + systemLogService.getSystemLogs());
    }
}
