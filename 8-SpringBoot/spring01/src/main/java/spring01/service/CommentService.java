package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;
import spring01.dao.CommentMapper;
import spring01.entity.Comment;
import spring01.util.CommunityConstant;
import spring01.util.SensitiveFilter;

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
public class CommentService implements CommunityConstant {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Autowired
    private DiscussPostService discussPostService;

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
    
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Input argument cannot be null!");
        }

        // 添加评论
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveFilter.filter(comment.getContent()));
        int rows = commentMapper.insertComment(comment);

        // 更新帖子评论数量
        if (comment.getEntityType() == ENTITY_TYPE_POST) {
            int count = commentMapper.selectCountByEntity(comment.getEntityType(), comment.getEntityId());
            discussPostService.updateCommentCount(comment.getEntityId(), count);
        }

        return rows;
    }

    /**
     * 更具用户id查询回复帖子的评论信息
     * @return
     */
    public List<Comment> findCommentsByUserIdForPost(int userId, int offset, int limit) {
        return commentMapper.selectCommentsByUserId(userId, ENTITY_TYPE_POST, offset, limit);
    }

    /**
     * 根据用户查询回复帖子的数量
     * @param userId
     * @return
     */
    public int findCommentsCountByUserIdForPost(int userId) {
        return commentMapper.selectCommentCountByUserIdAndEntityType(userId, ENTITY_TYPE_POST);
    }

    /**
     * 根据id查找comment.
     * @param id
     * @return
     */
    public Comment findCommentById(int id) {
        return commentMapper.selectCommentById(id);
    }
}
