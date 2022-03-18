package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import spring01.dao.AlphaDao;
import spring01.dao.DiscussPostMapper;
import spring01.dao.UserMapper;
import spring01.entity.DiscussPost;
import spring01.entity.User;
import spring01.util.CommunityUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaService
 * Author:   Peter
 * Date:     08/03/2022 18:23
 * Description:
 * History:
 * Version:
 */

@Service // 业务组件
//@Scope("prototype")  // 可实例化多个对象， 但是通常我们只是用单一对象
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public AlphaService() {
        System.out.println("Construct --- AlphaService");
    }

    @PostConstruct // 再构造器之后调用
    public void init() {
        System.out.println("Initialize the AlphaService!");
    }

    @PreDestroy // 销毁对象之前调用
    public void destroy() {

    }

    public String find() {
        return alphaDao.select();
    }

    /**
     * 事务绘画管理 - 声明式事务
     *
     * propagation: 传播机制， A调B
     *      - REQUIRED: 支持当前事务（外部事物，　即调用者），　如果不存在，则创建新事物
     *      －　REQUIRES_new: 创建一个新事物，　并且暂停当前事务（外部事物）
     *      - NESTED: 如果当前存在事务（外部事物），　则嵌套在该事务中执行（独立的提交和回滚），　否则就会ＲＥＱＵＩＲＥＤ　一样.
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) // 隔离事件， 默认会选择， 但是可以自己指定
    public Object save1() {
        // 新增用户
        User user = new User();
        user.setUsername("alpha");
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5("123") + user.getSalt());
        user.setEmail("alpha@qq.com");
        user.setHeaderUrl("http://image/nowcode.com/head/99t.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        // 新增帖子
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(user.getId());
        discussPost.setTitle("Hello");
        discussPost.setContent("New coder!");
        discussPost.setCreateTime(new Date());
        discussPostMapper.insertDiscussPost(discussPost);

        // 报错
        Integer.valueOf("abc");

        return "OK";
    }

    /**
     * 事务绘画管理 - 手写相关代码, 编程式事务
     * @return
     */
    public Object save2() {
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        return transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                // 新增用户
                User user = new User();
                user.setUsername("beta");
                user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
                user.setPassword(CommunityUtil.md5("123") + user.getSalt());
                user.setEmail("beta@qq.com");
                user.setHeaderUrl("http://image/nowcode.com/head/999t.png");
                user.setCreateTime(new Date());
                userMapper.insertUser(user);

                // 新增帖子
                DiscussPost discussPost = new DiscussPost();
                discussPost.setUserId(user.getId());
                discussPost.setTitle("Hello - beta");
                discussPost.setContent("New coder - beta!");
                discussPost.setCreateTime(new Date());
                discussPostMapper.insertDiscussPost(discussPost);

                // 报错
                Integer.valueOf("abc");

                return "OK";
            }
        });
    }
}
