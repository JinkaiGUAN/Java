package spring01.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
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
import spring01.util.RedisKeyUtil;

import javax.mail.event.MailEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${community.path.domain}") // 因为不是bean
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    //@Autowired
    //private LoginTicketMapper loginTicketMapper;

    public User findUserById(int id) {
        //return userMapper.selectByID(id);
        User user = getCache(id);
        if (user == null) {
            user = initCache(id);
        }

        return user;
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
            clearCache(userId);
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
        loginTicket.setTicket(CommunityUtil.generateUUID().replaceAll(" ", "-"));
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000L * expiredSeconds));

        //loginTicketMapper.insertLoginTicket(loginTicket);

        String redisKey = RedisKeyUtil.getTicketKey(loginTicket.getTicket());
        redisTemplate.opsForValue().set(redisKey, loginTicket);

        map.put("ticket", loginTicket.getTicket());

        return map;
    }

    public void logout(String ticket) {
        //loginTicketMapper.updateStatus(ticket, 1);
        String redisKey = RedisKeyUtil.getTicketKey(ticket);
        LoginTicket loginTicket = (LoginTicket) redisTemplate.opsForValue().get(redisKey);
        loginTicket.setStatus(1);
        redisTemplate.opsForValue().set(redisKey, loginTicket);
    }

    /**
     * 处理忘记密码功能
     *
     * 开发忘记密码的功能：
     * - 点击登录页面上的“忘记密码”链接，打开忘记密码页面。
     * - 在表单中输入注册的邮箱，点击获取验证码按钮，服务器为该邮箱发送一份验证码。
     * - 在表单中填写收到的验证码及新密码，点击重置密码，服务器对密码进行修改。
     *
     * 在用户提供邮箱之后也不需要给错误信息， 所有错误信息都在点击重置之后处理
     * @param email 输入邮箱
     * @param verifiedCodeSite 此处的验证码为服务器生成的验证码
     * @param verifiedCodeSession  次数验证码为服务器验证码
     */
    public Map<String, Object> forget(String email, String verifiedCodeSite, String verifiedCodeSession,
                                      String newPassword) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(email)) {
            map.put("emailEsg", "The email cannot be blank!");
            return map;
        }
        // 通过邮箱发送邮件, 首先要获取验证码
        // fixme: Finish the forget password function
        Context context = new Context();

        if (StringUtils.isBlank(verifiedCodeSite)) {
            map.put("codeMsg", "The verified code cannot be blank!");
            return map;
        }
        if (StringUtils.isBlank(newPassword)) {
            map.put("passwordMsg", "The new password cannot be blank!");
            return map;
        }

        // 首先通过email查找是否注册过 是否被激活 如果没有注册过 直接返回错误信息
        User user = userMapper.selectByEmail(email);
        if (user == null) {
            map.put("emailMsg", "The account has not registered yet!");
            return map;
        }
        if (user.getStatus() == 0) {
            map.put("emailMsg", "The email has not be activated yet!");
            return map;
        }

        return map;
    }

    /**
     * 发送验证密码邮件， 通过点击发送验证码按钮触发该业务
     * @param email 对应邮箱.
     * @param verifiedCode 验证码
     */
    public void sendVerifiedCode(String email, String verifiedCode) {
        Context context = new Context();
        context.setVariable("email", email);
        context.setVariable("verifyCode", verifiedCode);

        String content  = templateEngine.process("/mail/forget", context);
        mailClient.sendEmail(email, "重置密码", content);
    }

    // 重置密码
    public Map<String, Object> resetPassword(String email, String password) {
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(email)) {
            map.put("emailMsg", "邮箱不能为空!");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空!");
            return map;
        }

        // 验证邮箱
        User user = userMapper.selectByEmail(email);
        if (user == null) {
            map.put("emailMsg", "该邮箱尚未注册!");
            return map;
        }

        // 重置密码
        password = CommunityUtil.md5(password + user.getSalt());
        userMapper.updatePassword(user.getId(), password);

        map.put("user", user);
        return map;
    }

    public LoginTicket findLoginTicket(String ticket) {
        //return loginTicketMapper.selectByTicket(ticket);
        String redisKey = RedisKeyUtil.getTicketKey(ticket);
        return (LoginTicket) redisTemplate.opsForValue().get(redisKey);
    }

    /**
     * Update the header image for the specified id.
     * @param userId
     * @param headerUrl
     * @return
     */
    public int updateHeader(int userId, String headerUrl) {
        int rows = userMapper.updateHeader(userId, headerUrl);
        clearCache(userId);
        return rows;
    }

    /**
     * Modify the password. The dao has implemented the SQL, namely, updatePassword.
     * @param id : It is the id (primary key) in the user table.
     * @param newPassword : It is the new password.
     */
    public int modifyPassword(int id, String newPassword) {
        // modify the password, firstly, we need the id, then the new password. As for verifying the original
        // password, we will do it in the controller.
        return userMapper.updatePassword(id, newPassword);
    }

    public User findUserByName(String username) {
        return userMapper.selectByName(username);
    }

    /**
     * 管理用户缓存
     * 1. 优先从缓存中取值
     * 2. 取不到时初始化缓存数据
     * 3. 数据变更时清除缓存数据
     */
    //1. 优先从缓存中取值
    private User getCache(int userId) {
        String redisKey = RedisKeyUtil.getUserKey(userId);
        return (User) redisTemplate.opsForValue().get(redisKey);
    }

    //2. 取不到时初始化缓存数据
    private User initCache(int userId) {
        User user = userMapper.selectByID(userId);
        String redisKey = RedisKeyUtil.getUserKey(userId);
        redisTemplate.opsForValue().set(redisKey, user, 3600, TimeUnit.SECONDS);

        return user;
    }

    //3. 数据变更时清除缓存数据
    private void clearCache(int userId) {
        String redisKey = RedisKeyUtil.getUserKey(userId);
        redisTemplate.delete(redisKey);
    }
}

