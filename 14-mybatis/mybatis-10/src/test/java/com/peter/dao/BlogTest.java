package com.peter.dao;


import com.peter.pojo.Blog;
import com.peter.util.IdUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.peter.util.MyBatisUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
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
public class BlogTest {

    @Test
    public void testCreateInstance() throws Exception {
        // method 1: new
        Blog blog1 = new Blog();
        System.out.println(blog1);

        // method 2: reflection
        // using the newInstance() method of class will invoke the defaulted no arguments constructor
        Blog blog2 = Blog.class.newInstance();
        System.out.println(blog2);

        // using name
        Class p1 = Class.forName("com.peter.pojo.Blog");
        System.out.println(p1);
        Constructor p2 = p1.getConstructor(String.class, String.class, String.class, Date.class, int.class);
        blog2 = (Blog) p2.newInstance("12", "Tom", "tome", new Date(), 5);
        System.out.println(blog2);

        // Method 3: clone
        Employee emp3 = new Employee();

        Employee emp4 = (Employee) emp3.clone();
        emp4.setName("Atul");
        System.out.println(emp4 + ", hashcode : " + emp4.hashCode());

        // Method 4，反序列新建对象，By using Deserialization
        // Serialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(emp4);
        out.close();
        //Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        Employee emp5 = (Employee) in.readObject();
        in.close();
        emp5.setName("Akash");
        System.out.println(emp5 + ", hashcode : " + emp5.hashCode());

    }

    @Test
    public void testInsertData() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtil.generateId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.insertBlog(blog);

        blog.setId(IdUtil.generateId());
        blog.setTitle("Java如此简单");
        mapper.insertBlog(blog);

        blog.setId(IdUtil.generateId());

        blog.setTitle("Spring如此简单");
        mapper.insertBlog(blog);

        blog.setId(IdUtil.generateId());
        blog.setTitle("微服务如此简单");
        mapper.insertBlog(blog);

    }

    @Test
    public void testSelectBlogs() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogs = mapper.selectBlogs();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void testQueryBlogIf() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "Mybatis如此简单");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "动态SQL");
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","d0a1e20e50824406a8bf995854e29c47");

        mapper.updateBlog(map);
    }

    @Test
    public void testQueryBlogChoose() {
        SqlSession session = MyBatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        System.out.println(blogs);
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MyBatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

    }
}
