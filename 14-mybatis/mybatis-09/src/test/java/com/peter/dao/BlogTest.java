package com.peter.dao;


import com.peter.pojo.Blog;
import com.peter.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.peter.util.MyBatisUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.Date;
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
}
