package com.mobai.manager.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP切面方法
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Component
@Aspect
@Slf4j
public class UserAspect {
    /**
     * 切点前置通知
     */
    @Before("execution(* com.mobai.manager.service..*.*(..))")
    public void before() {
    }

    /**
     * 切点后置通知
     */
    @After("execution(* com.mobai.manager.service..*.*(..))")
    public void after() {
    }

    /**
     * 切点环绕通知
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.mobai.manager.controller..*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 切面中获取到调用方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 切面中获取到调用方法的参数
        Object[] args = proceedingJoinPoint.getArgs();

        log.info("method:{},param:{},before exec", methodName, Arrays.toString(args));

        // 执行调用方法
        Object result = proceedingJoinPoint.proceed();

        log.info("method:{},param:{},after exec", methodName, Arrays.toString(args));

        return result;
    }

    /**
     * 切点后置通知返回值
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "execution(* com.mobai.manager.service..*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result) {
    }

    /**
     * 切点后置通知异常返回
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "execution(* com.mobai.manager.service..*.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
    }
}
