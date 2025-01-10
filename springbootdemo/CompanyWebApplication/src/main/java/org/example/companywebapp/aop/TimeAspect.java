package org.example.companywebapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    //@Around("execution(* org.example.companywebapp.controller.*.*(..))")
    @Around("execution(* org.example.companywebapp.controller.MainController.home(..))")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object=proceedingJoinPoint.proceed();
        //time calculate
        long end = System.currentTimeMillis();
System.out.println(proceedingJoinPoint.getSignature().getName());
        System.out.println("Time Calculated :::: "+(end-start)+" ms");
        return object;
    }
}
