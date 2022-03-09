package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring01.dao.DiscussPostMapper;
import spring01.entity.DiscussPost;

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

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
