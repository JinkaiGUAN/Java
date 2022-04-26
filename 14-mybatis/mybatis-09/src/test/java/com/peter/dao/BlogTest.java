package com.peter.dao;


import com.peter.pojo.Blog;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.peter.util.MyBatisUtil;

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
    public void testSelectBlogs() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogs = mapper.selectBlogs();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }
}
