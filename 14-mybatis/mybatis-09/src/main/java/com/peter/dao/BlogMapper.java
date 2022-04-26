package com.peter.dao;

import com.peter.pojo.Blog;

import java.util.List;

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
}
