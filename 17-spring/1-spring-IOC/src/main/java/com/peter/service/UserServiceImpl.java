package com.peter.service;

import com.peter.dao.UserDao;
import com.peter.dao.UserDaoImpl;
import com.peter.dao.UserDaoMySqlImpl;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserServiceImpl
 * Author:   Peter
 * Date:     28/04/2022 08:42
 * Description:
 * History:
 * Version:
 */


//public class UserServiceImpl implements UserService {
//
//    /**
//     * 这种方式每次增加一种dao接口， 就必须改动代码， 耦合性很高
//     */
//    //private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMySqlImpl();
//
//    @Override
//    public void getUser() {
//        userDao.getUser();
//    }
//}

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * 使用set方法， 自定义传入Dao 种类
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
