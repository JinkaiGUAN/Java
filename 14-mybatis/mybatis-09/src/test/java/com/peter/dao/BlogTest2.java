package com.peter.dao;


import com.peter.pojo.Blog;
import com.peter.util.IdUtil;
import com.peter.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: BlogTest
 * Author:   Peter
 * Date:     26/04/2022 08:18
 * Description:
 * History:
 * Version:
 */
public class BlogTest2 {

    @Test
    public void testSelectBlogs() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogs = mapper.selectBlogs();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectBlogById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = mapper.selectBlogById("1");
        System.out.println(blog);
        // 一级缓存
        Blog blog1 = mapper.selectBlogById("1");
        System.out.println(blog1);

        sqlSession.close();
    }

    /**
     *         查询在中间执行了增删改操作后，重新执行了
     *         结论：因为增删改操作可能会对当前数据产生影响
     */
    @Test
    public void testCache1() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = mapper.selectBlogById("1");
        System.out.println(blog);

        HashMap<String, String> map = new HashMap<>();
        map.put("title", "cache");
        map.put("id", "1");
        mapper.updateBlog(map);

        Blog blog1 = mapper.selectBlogById("1");
        System.out.println(blog1);

        sqlSession.close();
    }

    /**
     * 手动清理缓存， 一级缓存就是一个map
     */
    @Test
    public void testCache2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = mapper.selectBlogById("1");
        System.out.println(blog);

        sqlSession.clearCache();

        Blog blog1 = mapper.selectBlogById("1");
        System.out.println(blog);

        System.out.println(blog == blog1);

        sqlSession.close();
    }

    /**
     * 测试全局缓存
     *
     * 只要开启了二级缓存，我们在同一个Mapper中的查询，可以在二级缓存中拿到数据
     *
     * 查出的数据都会被默认先放在一级缓存中
     *
     * 只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中
     */
    @Test
    public void testCache3() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        BlogMapper mapper1 = sqlSession1.getMapper(BlogMapper.class);

        Blog blog = mapper.selectBlogById("1");
        System.out.println(blog);
        sqlSession.close();

        Blog blog1 = mapper1.selectBlogById("1");
        System.out.println(blog1);
        sqlSession1.close();

        System.out.println(blog == blog1);
    }

}
