package spring01.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import spring01.dao.LoginTicketMapper;
import spring01.dao.UserMapper;
import spring01.entity.LoginTicket;
import spring01.entity.User;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;
import spring01.util.MailClient;

import javax.mail.event.MailEvent;
import java.util.*;

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
public class UserService implements CommunityConstant {
    // 与user有关操作

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${community.path.domain}") // 因为不是bean
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    public User findUserById(int id) {
        return userMapper.selectByID(id);
    }

    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();

        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }

        // 次数不是代码逻辑出错 而是输入信息出错
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMsg", "Account cannot be null!");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg", "Password cannot be null!");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("userEmailMsg", "Email cannot be null!");
            return map;
        }

        // 验证账号
        User usernameVerified = userMapper.selectByName(user.getUsername());
        if  (usernameVerified != null) {
            map.put("usernameMsg", "The inputted username already exists!");
            return map;
        }
        // 验证邮箱
        User userEmailVerified = userMapper.selectByEmail(user.getEmail());
        if (userEmailVerified != null) {
            map.put("userEmailMsg", "The email has been used before!");
            return map;
        }

        // 注册用户
        // 密码加密
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5(user.getPassword() + user.getSalt()));
        // 设置 参数
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(CommunityUtil.generateUUID());
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertUser(user);  // 加入数据库之后就有ID

        // 发送激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // http://localhost:8080/community/activation/101/code
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);

        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendEmail(user.getEmail(), "激活账号", content);

        return map;
    }

    public int activation(int userId, String code) {
        User user = userMapper.selectByID(userId);
        if (user.getStatus() == 1) {
            return ACTIVATION_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            userMapper.updateStatus(user.getId(), 1);
            return ACTIVATION_SUCCESS;
        } else {
            return ACTIVATION_FAILURE;
        }
    }

    public Map<String, Object> login(String username, String password, int expiredSeconds) {
        // 此处password是网页输入的明文

        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg", "Username cannot be blank!");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "Password cannot be blank!");
            return map;
        }

        // 验证账号， user是否存在， 是否被激活， 验证密码
        User user = userMapper.selectByName(username);
        if (user == null) {
            map.put("usernameMsg", "The account does not exits!");
            return map;
        }
        if (user.getStatus() == 0) {
            map.put("usernameMsg", "The account has not bee activated!");
            return map;
        }
        password = CommunityUtil.md5(password + user.getSalt());
        if (!password.equals(user.getPassword())) {
            map.put("passwordMsg", "The password is not correct!");
            return map;
        }

        // 生成登录凭证
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(user.getId());
        loginTicket.setTicket(CommunityUtil.generateUUID());
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000L * expiredSeconds));

        map.put("ticket", loginTicket.getTicket());

        return map;
    }


}

