package com.peter.dao;

import com.peter.pojo.Blog;
import org.apache.ibatis.annotations.Param;

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

    Blog selectBlogById(@Param("id") String id);

    int updateBlog(Map map);

}
