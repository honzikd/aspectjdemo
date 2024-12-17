package com.honzikd.aspectj_demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TimeTrackedAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.honzikd.aspectj_demo.annotations.TimeTracked)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long timeSpent = System.currentTimeMillis() - timeStart;
            logger.info("Time spent in: {} was: {} ms", joinPoint.toShortString(), timeSpent);
        }
    }

}
