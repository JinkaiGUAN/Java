package com.peter.dao;

import com.peter.pojo.User;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserMapper
 * Author:   Peter
 * Date:     19/04/2022 20:01
 * Description:
 * History:
 * Version:
 */
public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int user);

}
