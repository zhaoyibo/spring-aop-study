package com.ideassea.springaop.aop;


import com.ideassea.springaop.util.MonitorSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
@Aspect
@Component
public class MonitorAdvice {

    @Pointcut("execution (* com.ideassea.springaop.service.Speakable.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.start(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }

}
