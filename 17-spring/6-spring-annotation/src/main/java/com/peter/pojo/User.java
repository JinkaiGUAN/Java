package com.peter.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), Peter GUAN
 * FileName: User
 * Author:   Peter
 * Date:     01/05/2022 19:35
 * Description:
 * History:
 * Version:
 */

// 相当于xml配置文件中 <bean id="user", class="com.peter.pojo.User"/>
@Component("user")
public class User {

    @Value("Tom")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
