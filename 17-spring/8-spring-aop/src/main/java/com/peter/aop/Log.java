package com.peter.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Copyright (C), Peter GUAN
 * FileName: Log
 * Author:   Peter
 * Date:     04/05/2022 08:48
 * Description:
 * History:
 * Version:
 */
public class Log implements MethodBeforeAdvice {

    /**
     *
     * @param method: 要执行的目标对象的方法
     * @param objects: 被调用的方法的参数
     * @param o: 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + " 's " + method.getName() + " is executed!");
    }
}
