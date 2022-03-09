package spring01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.dao.UserMapper;
import spring01.entity.User;

import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: MapperTests
 * Author:   Peter
 * Date:     09/03/2022 09:12
 * Description: test the performance of mapper
 * History:
 * Version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectByID(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("Test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("adfw@qq.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/100.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());  // w为什么ID可以生成
    }

    @Test
    public void testUpdateUser() {
        int row = userMapper.updateStatus(150, 1);
        System.out.println(row);

        row = userMapper.updateHeader(150, "http://images.nowcoder.com/head/101.png");
        System.out.println(row);

        row = userMapper.updatePassword(150, "aghduqguq");
        System.out.println(row);
    }
}
