package com.keshav.Job.App.Rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

   // @Before("execution(* com.keshav.Job.App.Rest.service.JobService.getPost(..))") // I determined when i want a log and that point is getPost is the concept of Joint Point
    @Before("execution(* com.keshav.Job.App.Rest.service.JobService.getPost(..)) || execution(* com.keshav.Job.App.Rest.service.JobService.deleteJob(..))")
    //Here we are using Joint Point for two method simultaneously.
    public void logMethodCall(JoinPoint jp){
        LOGGER.info(" Method Called " + jp.getSignature().getName());
    }
}
