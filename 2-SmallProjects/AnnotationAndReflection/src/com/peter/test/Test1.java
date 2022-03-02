package com.peter.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test1
 * Author:   Peter
 * Date:     02/03/2022 20:05
 * Description:
 * History:
 * Version:
 */
public class Test1 {

    // 注解可以显示赋值， 如果没有默认值， 就必须给注解赋值
    @MyAnnotations(age = 18, schools = {"Newloy"})
    public void test01(){
    }

    @MyAnnotation2("dhahh")
    public void test2() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})  // 元注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
    // 注解的参数: 参数类型 + 参数名（）
    String name() default "";
    int age();
    int id() default -1;  // 默认值位-1 表示不存在

    String[] schools() default {"qinghua"};

}

@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotation2 {
    String value();  // 只有一个参数的， 一般定义为value（）。
}