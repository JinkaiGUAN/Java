package com.peter;

import com.peter.dao.UserDaoMySqlImpl;
import com.peter.dao.UserDaoOracleImpl;
import com.peter.service.UserService;
import com.peter.service.UserServiceImpl;
import org.junit.Test;

/**
 * Copyright (C), Peter GUAN
 * FileName: IoCTest
 * Author:   Peter
 * Date:     28/04/2022 08:43
 * Description:
 * History:
 * Version:
 */

public class IoCTest {

    /**
     * 原始获得用户的方式
     */
    @Test
    public void testOrigin() {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }

    @Test
    public void testUseSetMethod() {
        UserServiceImpl userService = new UserServiceImpl();
        // 使用MySQL
        userService.setUserDao(new UserDaoMySqlImpl());
        userService.getUser();

        // 使用Oracle
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

}
