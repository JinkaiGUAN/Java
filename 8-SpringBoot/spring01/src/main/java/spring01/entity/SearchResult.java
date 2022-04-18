package spring01.entity;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName:    SearchResult
 *
 * @Author: Peter
 * Date:        01/04/2022 11:12
 * Description: 用于暂存es中查询到的列表和行数
 * History:
 * Version:
 */
public class SearchResult {
    private List<DiscussPost> posts;
    // 数量
    private long total;

    public SearchResult(List<DiscussPost> posts, long total) {
        this.posts = posts;
        this.total = total;
    }

    public List<DiscussPost> getPosts() {
        return posts;
    }

    public void setPosts(List<DiscussPost> posts) {
        this.posts = posts;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "posts=" + posts +
                ", total=" + total +
                '}';
    }
}
