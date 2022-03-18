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

    public List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit) {
        return commentMapper.selectCommentsByEntity(entityType, entityId, offset, limit);
    }

    public int findCommentCount(int entityType, int entityId) {
        return commentMapper.selectCountByEntity(entityType, entityId);
    }
}
