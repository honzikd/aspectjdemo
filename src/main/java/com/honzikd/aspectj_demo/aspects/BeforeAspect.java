package com.honzikd.aspectj_demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Before("execution(* com.honzikd.aspectj_demo.service.*.*(..))")
//    public void beforeInline(JoinPoint joinPoint) {
//        logger.info("Inline: Before executing {}", joinPoint.toShortString());
//    }

    @Before("com.honzikd.aspectj_demo.pointcuts.CommonPointcuts.inService()")
    public void beforeNamed(JoinPoint joinPoint) {
        logger.info("Named: Before executing {}", joinPoint.toShortString());
    }
}
