package com.waa.project.aspect;

import com.waa.project.util.LoggingUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @After("@annotation(com.waa.project.aspect.annotation.LogMe)")
    public void log(JoinPoint joinPoint){
        LoggingUtil.logMessage("Method Excution: " + joinPoint.getSignature().getName());
    }
}
