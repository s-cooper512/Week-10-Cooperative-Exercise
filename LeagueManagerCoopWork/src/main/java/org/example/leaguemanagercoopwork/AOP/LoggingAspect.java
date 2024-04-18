package org.example.leaguemanagercoopwork.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    // Define the pointcut to target controller methods
    @Pointcut("execution(* org.example.leaguemanagercoopwork.controller..*.*(..))")
    public void controllerMethods() {}

    // Advice to log before controller methods execution
    @Before("controllerMethods()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("Before method: " + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
    }

    // Advice to log after controller methods execution
    @After("controllerMethods()")
    public void logAfterMethod(JoinPoint joinPoint) {
        log.info("After method: " + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
    }
}