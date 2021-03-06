package com.peter.dao;

import com.peter.pojo.User;
import com.peter.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserMapperTest
 * Author:   Peter
 * Date:     19/04/2022 20:14
 * Description:
 * History:
 * Version:
 */
public class UserMapperTest {

    @Test
    public void test() {

        // get the object of sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            for(User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("Tom");
        user.setPassword("12345678");
        int res = mapper.insertUser(user);
        if (res > 0) {
            System.out.println("Insert successfully");
        }

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper  = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("Tom1");
        user.setPassword("12345678!");
        mapper.updateUser(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        sqlSession.commit();

        sqlSession.close();
    }
}
