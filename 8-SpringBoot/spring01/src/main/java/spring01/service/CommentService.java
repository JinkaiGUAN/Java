package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring01.dao.CommentMapper;
import spring01.entity.Comment;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: CommentService
 * Author:   Peter
 * Date:     18/03/2022 09:47
 * Description:
 * History:
 * Version:
 */

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     *
     * @param entityType: 表示回复的种类， 即针对用户回复还是帖子回复，。。。
     * @param entityId: 表示当前实体的ID， eg， 如果当前实体是帖子， 那么该变量九尾当前贴子在数据表中的id值。
     * @param offset: 前面页面已经显示的记录
     * @param limit: 当前页面最多显示的记录
     * @return
     */
    public List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit) {
        return commentMapper.selectCommentsByEntity(entityType, entityId, offset, limit);
    }

    public int findCommentCount(int entityType, int entityId) {
        return commentMapper.selectCountByEntity(entityType, entityId);
    }
}
