package spring01.dao;

import org.apache.ibatis.annotations.Mapper;
import spring01.entity.Comment;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: CommentMapper
 * Author:   Peter
 * Date:     18/03/2022 09:31
 * Description:
 * History:
 * Version:
 */

@Mapper
public interface CommentMapper {

    /**
     * 返回当前实体的该页下的评论
     * @param entityType
     * @param entityId
     * @param offset
     * @param limit
     * @return
     */
    List<Comment> selectCommentsByEntity(int entityType, int  entityId, int offset, int limit);

    /**
     * 获取实体的全部评论
     * @param entityType
     * @param entityId
     * @return
     */
    int selectCountByEntity(int entityType, int entityId);

    /**
     * 添加评论
     *
     * 注意添加评论时， 也要对回帖相关表中的内容进行修改， 保证事务的遵循ACID原则
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    /**
     * 查询当前用户当前页下针对帖子的回复
     *
     * @param userId
     * @param entityType : the type should be 1
     * @param offset
     * @param limit
     * @return
     */
    List<Comment> selectCommentsByUserId(int userId, int entityType, int offset, int limit);

    int selectCommentCountByUserIdAndEntityType(int userId, int entityType);
}
