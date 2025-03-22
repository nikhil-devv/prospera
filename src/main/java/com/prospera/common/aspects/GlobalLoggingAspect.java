package com.prospera.common.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class GlobalLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLoggingAspect.class);

    @Before("execution(* com.prospera..*(..))")
    public void logMethodExecutionBfore(JoinPoint joinPoint){
        logger.info("Entering into : " + getPackageAndMethodName(joinPoint.getSignature()));
    }

    @AfterReturning(pointcut = "execution(* com.prospera..*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        logger.info("Exiting from :" + getPackageAndMethodName(joinPoint.getSignature()));
    }

    final private String getPackageAndMethodName(Signature signature){
        return signature.getDeclaringTypeName()+"."+signature.getName();
    }



}
