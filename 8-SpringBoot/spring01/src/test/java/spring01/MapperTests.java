package spring01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.dao.DiscussPostMapper;
import spring01.dao.LoginTicketMapper;
import spring01.dao.UserMapper;
import spring01.entity.DiscussPost;
import spring01.entity.LoginTicket;
import spring01.entity.User;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;

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

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abs");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectByTicket() {
        String ticket = "abs";
        LoginTicket loginTicket = loginTicketMapper.selectByTicket(ticket);
        System.out.println(loginTicket);

        //update the status
        loginTicketMapper.updateStatus(ticket, 1);
        loginTicket = loginTicketMapper.selectByTicket(ticket);
        System.out.println(loginTicket);
    }

}
