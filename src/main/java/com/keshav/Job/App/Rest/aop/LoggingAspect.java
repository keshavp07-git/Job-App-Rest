package com.keshav.Job.App.Rest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    // From Logger Class we create LOGGER object of that class
    // Then we use LoggerFactory.getLogger(LoggingAspect.class);
    // Here it required class which will be same as our class name that why here LoggingAspect.class in pass
    // in Parameter

    public void logMethodCall(){ // We make a method which call LOGGER with functionality of Logger Class
        // And we call the method and a message.
        LOGGER.info("Method Called");
    }
}
