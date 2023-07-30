package com.waa.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingUtil {
    public LoggingUtil() {

    }

    public static void logMessage(String message) {
        String callerClassName = new Throwable().getStackTrace()[1].getClassName();
        Logger log = LoggerFactory.getLogger(callerClassName);
        log.info("Logged message: {}", message);
    }
}

