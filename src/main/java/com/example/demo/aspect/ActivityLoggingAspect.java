package com.example.demo.aspect;

import com.example.demo.annotation.LogActivity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class ActivityLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(ActivityLoggingAspect.class);

    @Around("@annotation(logActivity)")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint, LogActivity logActivity) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("[" + getTimestamp() + "] "+"Before executing {}()", logActivity.value());

        Object result = proceedingJoinPoint.proceed();

        if (result instanceof ResponseEntity<?> responseEntity) {
            HttpStatusCode httpStatus = responseEntity.getStatusCode();

            if (isGetMethod(methodName)) {
                long id = (long) proceedingJoinPoint.getArgs()[0];
                String logMessage = "[" + getTimestamp() + "] " + logActivity.value() + " of id: " + id + " - HTTP Status Code: " + httpStatus.value();
                logStatusMessage(logMessage, httpStatus);
            } else {
                String logMessage = "[" + getTimestamp() + "] " + logActivity.value() + " - HTTP Status Code: " + httpStatus.value();
                logStatusMessage(logMessage, httpStatus);
            }
        } else if (result instanceof ResponseStatusException responseStatusException) {
            HttpStatusCode httpStatus = responseStatusException.getStatusCode();
            System.out.println("response status exception");
            if (isGetMethod(methodName)) {
                long id = (long) proceedingJoinPoint.getArgs()[0];
                String logMessage = "[" + getTimestamp() + "] " + logActivity.value() + " of id: " + id + " - HTTP Status Code: " + httpStatus.value();
                logStatusMessage(logMessage, httpStatus);
            } else {
                String logMessage = "[" + getTimestamp() + "] " + logActivity.value() + " - HTTP Status Code: " + httpStatus.value();
                logStatusMessage(logMessage, httpStatus);
            }
        }

        return result;
    }
    private boolean isGetMethod(String methodName) {
        return methodName.equalsIgnoreCase("getById") ||
                methodName.equalsIgnoreCase("delete") ||
                methodName.equalsIgnoreCase("update");
    }
    private void logStatusMessage(String logMessage, HttpStatusCode httpStatus) {
        if (httpStatus.is2xxSuccessful()) {
            logger.info(logMessage);
        } else if (httpStatus.is4xxClientError()) {
            logger.warn(logMessage);
        } else if (httpStatus.is5xxServerError()) {
            logger.error(logMessage);
        } else {
            logger.info(logMessage);
        }
    }

    private String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now);
    }


}
