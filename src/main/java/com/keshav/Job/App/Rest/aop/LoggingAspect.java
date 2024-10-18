package com.keshav.Job.App.Rest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect // This annotation tells that this is Aspect , This class will hold concerns.
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // Declare type of execution before , after , after execution , around execution.
    // return type class-name.method-name(args)
    // all type of return type use * if not use proper name , int or string
    // all type of class name use * if not use proper name , com.keshav.Job.App.Rest.service;
    // all type of args use (..) if not use proper name , jobservice etc


    // @Before("execution(* *.*(..)") // Eg. of Annotation Which work of everything
    @Before("execution(* com.keshav.Job.App.Rest.service.JobService.*(..))") // This is the advice type, This work for only one class-name ---> JobService
    public void logMethodCall(){
        LOGGER.info("Method Called");
    }
}
