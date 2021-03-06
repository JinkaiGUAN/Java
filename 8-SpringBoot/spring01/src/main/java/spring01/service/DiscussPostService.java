package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import spring01.dao.DiscussPostMapper;
import spring01.entity.DiscussPost;
import spring01.util.SensitiveFilter;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: DiscussPostService
 * Author:   Peter
 * Date:     09/03/2022 11:28
 * Description:
 * History:
 * Version:
 */

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private SensitiveFilter sensitiveFilter;

    /**
     * 查询帖子
     * @param userId
     * @param offset
     * @param limit
     * @param orderMode，提供两种方式进行排序， 0为默认按照type和时间， 1增加了按照score排序。
     * @return
     */
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit, int orderMode ) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit, orderMode);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    public int addDiscussPost(DiscussPost discussPost) {
        if (discussPost == null) {
            throw new IllegalArgumentException("Arguments should be null!");
        }

        // 转义 html标记
        discussPost.setTitle(HtmlUtils.htmlEscape(discussPost.getTitle()));
        discussPost.setContent(HtmlUtils.htmlEscape(discussPost.getContent()));
        // 过滤铭感词
        discussPost.setTitle(sensitiveFilter.filter(discussPost.getTitle()));
        discussPost.setContent(sensitiveFilter.filter(discussPost.getContent()));

        return discussPostMapper.insertDiscussPost(discussPost);
    }

    public DiscussPost findDiscussPostById(int id) {
        return discussPostMapper.selectDiscussPostById(id);
    }

    /**
     * 更新帖子数量
     * @param id
     * @param commentCount
     * @return
     */
    public int updateCommentCount(int id, int commentCount) {
        return discussPostMapper.updateCommentCount(id, commentCount);
    }

    /**
     * 根据输入的discuss-post的id查询相应的标题
     * @param ids
     * @return
     */
    @Deprecated
    public List<DiscussPost> findDiscussPostByIds(List<Integer> ids) {
        return discussPostMapper.selectDiscussPostByIds(ids);
    }

    /**
     * 根据实体ID更改type。
     * @param entityId
     * @param type
     * @return
     */
    public int updateType(int entityId, int type) {
        return discussPostMapper.updateType(entityId, type);
    }

    /**
     * 根据实体ID更改状态
     * @param entityId
     * @param type
     * @return
     */
    public int updateStatus(int entityId, int type) {
        return discussPostMapper.updateStatus(entityId, type);
    }

    /**
     * 根据实体ID更改评分
     * @param id
     * @param score
     * @return
     */
    public int updateScore(int id, double score) {
        return discussPostMapper.updateScore(id, score);
    }
}
