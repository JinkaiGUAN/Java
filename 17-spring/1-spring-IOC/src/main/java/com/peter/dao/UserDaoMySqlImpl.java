package com.peter.dao;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserDaoMySqlImpl
 * Author:   Peter
 * Date:     28/04/2022 08:46
 * Description:
 * History:
 * Version:
 */
public class UserDaoMySqlImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("MySQL 获取用户数据！");
    }
}
