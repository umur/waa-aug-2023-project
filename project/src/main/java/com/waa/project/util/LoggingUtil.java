package com.waa.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingUtil {
    // Private constructor to prevent instantiation of the utility class
    public LoggingUtil() {

    }

    // Example method that uses the logger to log a message
    public static void logMessage(Class<?> clazz, String message) {
        Logger log = LoggerFactory.getLogger(clazz);
        log.info("Logged message: {}", message);
    }
}

