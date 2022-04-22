package com.peter.dao;

import com.peter.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id, name, password) values(#{id}, #{name}, #{password})")
    int insertUser(User user);

    @Update("update user set id=#{id}, name=#{name}, password=#{password}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int userId);

}
