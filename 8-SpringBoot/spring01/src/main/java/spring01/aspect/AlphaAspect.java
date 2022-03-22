package spring01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaAspect
 * Author:   Peter
 * Date:     22/03/2022 09:53
 * Description:
 * History:
 * Version:
 */

//fixme: 为什么用Aspect注解也要用Component
//@Component
//@Aspect
public class AlphaAspect {

    @Pointcut("execution(* spring01.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around before");
        Object obj = joinPoint.proceed(); // 调用目标组件执行代码
        System.out.println("Around after");
        return obj;
    }

}
