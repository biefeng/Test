package com.biefeng.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author BieFeNg
 * @Date 2018-06-09 13:41
 * @Desc
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.biefeng.spring.aop.Perform.perform(..))")
    public void perform(){

    }

    @Before("perform()")
    public void silenceCellPhone(){
        System.out.println("Before ,silence your cellphone");
    }

    /**
     * 对于环绕通知，可以有ProceddingJoinPoint参数
     * @param joinPoint
     */
    @Around("perform()")
    public void watchPerformacne(ProceedingJoinPoint joinPoint){

    }
}
