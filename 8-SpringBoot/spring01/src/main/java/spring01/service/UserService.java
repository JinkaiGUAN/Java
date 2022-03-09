package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring01.dao.UserMapper;
import spring01.entity.User;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserService
 * Author:   Peter
 * Date:     09/03/2022 11:35
 * Description:
 * History:
 * Version:
 */

@Service
public class UserService {
    // 与user有关操作

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectByID(id);
    }
}

