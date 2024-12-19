package com.honzikd.aspectj_demo.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

//    Full list of supported pointcut designators:
//    https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html#aop-pointcuts-designators
//    https://eclipse.dev/aspectj/doc/released/progguide/index.html

    @Pointcut("within(com.xyz.web..*)")
    public void inWebLayer() {}

    @Pointcut("execution(* com.honzikd.aspectj_demo.service.*.*(..))")
    public void inService() {}

}
