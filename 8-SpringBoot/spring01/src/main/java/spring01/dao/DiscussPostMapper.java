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
 * @author Peter
 */

@Mapper
public interface DiscussPostMapper {

    /**
     * 通过用户名查询所有的论坛
     * @param userId 用户名
     * @param offset 起始行行号
     * @param limit 每页展示的数据量
     * @param orderMode 默认为0，如果为1 则是按照热度
     * @return 所有post的数组
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

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

    /**
     * 通过ID查询帖子详细信息
     * @param id
     * @return
     */
    DiscussPost selectDiscussPostById(int id);


    /**
     * 根据评论id来更新帖子回复数量
     * @param id
     * @param commentCount
     * @return
     */
    int updateCommentCount(int id, int commentCount);

    /**
     * 查询id为对应entity id的所有discuss post实体。
     * @param ids: 此处的ids数量应该被page的limit限制
     * @return
     */
    List<DiscussPost> selectDiscussPostByIds(List<Integer> ids);

    /**
     * 根据实体ID更改type。
     * @param id
     * @param type
     * @return
     */
    int updateType(int id, int type);

    /**
     * 根据实体ID更改状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(int id, int status);

    /**
     * 根据实体ID更改评分
     * @param id
     * @param score
     * @return
     */
    int updateScore(int id, double score);
}
