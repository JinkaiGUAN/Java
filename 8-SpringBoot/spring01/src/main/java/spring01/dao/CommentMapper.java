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
}
