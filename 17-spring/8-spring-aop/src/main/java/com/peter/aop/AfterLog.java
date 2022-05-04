package com.peter.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Copyright (C), Peter GUAN
 * FileName: AfterLog
 * Author:   Peter
 * Date:     04/05/2022 08:51
 * Description:
 * History:
 * Version:
 */
public class AfterLog implements AfterReturningAdvice {

    /**
     *
     * @param o: 返回值
     * @param method: 被调用的方法
     * @param objects: 被调用的方法的对象的参数
     * @param o1:  被调用的目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Executed " + o1.getClass().getName() + " 's " +
                method.getName() + ", return value is " + 0);
    }
}
