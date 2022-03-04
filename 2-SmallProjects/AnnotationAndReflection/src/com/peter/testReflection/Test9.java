package com.peter.testReflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test9
 * Author:   Peter
 * Date:     04/03/2022 09:12
 * Description: 获取泛型
 * History:
 * Version:
 */
public class Test9 {
    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test9.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualType : actualTypes) {
                    System.out.println(actualType);
                }
            }
        }

        System.out.println(" ------------------- ");

        method = Test9.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] parameterizedTypes = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type parameterizedType : parameterizedTypes) {
                System.out.println(parameterizedType);
            }
        }
    }

}


