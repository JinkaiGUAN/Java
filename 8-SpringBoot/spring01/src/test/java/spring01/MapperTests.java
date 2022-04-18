package spring01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.dao.DiscussPostMapper;
import spring01.dao.LoginTicketMapper;
import spring01.dao.MessageMapper;
import spring01.dao.UserMapper;
import spring01.entity.DiscussPost;
import spring01.entity.LoginTicket;
import spring01.entity.Message;
import spring01.entity.User;

import java.io.FilterOutputStream;
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
    @Autowired
    private MessageMapper messageMapper;

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
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10, 0);
        for (DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testInsertDiscussPost() {
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(101);
        discussPost.setTitle("Test");
        discussPost.setContent("The test content!");
        discussPost.setType(0);
        discussPost.setStatus(0);
        discussPost.setCreateTime(new Date());
        discussPost.setCommentCount(0);
        discussPost.setScore(0);

        int row = discussPostMapper.insertDiscussPost(discussPost);
        System.out.println(row);
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

    @Test
    public void testSelectLetters() {
        System.out.println(" ============ selectConversations ===================");
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }

        System.out.println(" ============ selectConversationCount ===================");
        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        System.out.println(" ============ selectLetters ===================");
        messages = messageMapper.selectLetters("111_112", 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }

        System.out.println(" ============ selectLettersCount( ===================");
        count = messageMapper.selectLettersCount("111_112");
        System.out.println(count);

        System.out.println(" ============ selectLettersUnreadCount ===================");
        //count = messageMapper.selectLettersUnreadCount(111, "");
        //System.out.println(count);
        count = messageMapper.selectLettersUnreadCount(131, "111_131");
        System.out.println(count);

    }
}
