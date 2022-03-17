package spring01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spring01.entity.DiscussPost;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: DiscussPostMapper
 * Author:   Peter
 * Date:     09/03/2022 10:21
 * Description: Discuss post 表单mapper
 * History:
 * Version:
 */

@Mapper
public interface DiscussPostMapper {

    /**
     * 通过用户名查询所有的论坛
     * @param userId 用户名
     * @param offset 起始行行号
     * @param limit 每页展示的数据量
     * @return 所有post的数组
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 动态编写sql并且再If中使用 且该方法只有一个输入参数， 纳闷我们就要使用注解 Param， 用来给参数取别名。
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    /**
     * 插入帖子
     * @param discussPost
     * @return
     */
    int insertDiscussPost(DiscussPost discussPost);
}
