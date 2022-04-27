package com.peter.dao;

import com.peter.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: BlogMapper
 * Author:   Peter
 * Date:     26/04/2022 08:22
 * Description:
 * History:
 * Version:
 */
public interface BlogMapper {

    List<Blog> selectBlogs();

    int insertBlog(Blog blog);

    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
