package spring01.service;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring01.dao.elasticsearch.DiscussPostRepository;
import spring01.entity.DiscussPost;
import spring01.entity.SearchResult;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName:    ElasticsearchService
 *
 * @Author: Peter
 * Date:        01/04/2022 10:13
 * Description: 针对discusspost存入 删除 搜索在es
 * History:
 * Version:
 */

@Service
public class ElasticsearchService {

    @Value("${elasticsearch.reponame}")
    private String discussPostRepoName;

    @Autowired
    private DiscussPostRepository discussPostRepository;

    @Qualifier("client")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 将帖子存入ES服务中
     * @param post
     */
    public void saveDiscussPost(DiscussPost post) {
        discussPostRepository.save(post);
    }

    /**
     * 根据在ES中删除帖子
     * @param id
     */
    public void deleteDiscussPost(int id) {
        discussPostRepository.deleteById(id);
    }

    /**
     * 搜索帖子关键字
     * @param keyword
     * @param current: 搜索的开始索引 【Set the `current` option that determines the result index to start searching from.
     *               Defaults to 0.】
     * @param limit: 一次搜索出来多少条信息
     */
    public SearchResult searchDiscussPost(String keyword, int current, int limit) throws IOException {
        SearchRequest searchRequest = new SearchRequest(discussPostRepoName);

        // high light
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field("title")
                .field("content")
                .requireFieldMatch(false)
                .preTags("<em>")
                .postTags("</em>");

        // query condition
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.multiMatchQuery(keyword, "title", "content"))
                .sort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .from(current)
                .size(limit)
                .highlighter(highlightBuilder);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits().value;
        if (total <= 0) {
            return null;
        }

        List<DiscussPost> discussPosts = new LinkedList<>();
        for (SearchHit hit : hits) {
            DiscussPost discussPost = JSONObject.parseObject(hit.getSourceAsString(), DiscussPost.class);

            //DiscussPost discussPost = new DiscussPost();

            //String id = hit.getSourceAsMap().get("id").toString();
            //discussPost.setId(Integer.valueOf(id));
            //
            //String userId = hit.getSourceAsMap().get("userId").toString();
            //discussPost.setUserId(Integer.valueOf(userId));
            //
            //String title = hit.getSourceAsMap().get("title").toString();
            //discussPost.setTitle(title);
            //
            //String content = hit.getSourceAsMap().get("content").toString();
            //discussPost.setContent(content);
            //
            //String status = hit.getSourceAsMap().get("status").toString();
            //discussPost.setStatus(Integer.valueOf(status));
            //
            //String createTime = hit.getSourceAsMap().get("createTime").toString();
            //discussPost.setCreateTime(new Date(Long.valueOf(createTime)));
            //
            //String commentCount = hit.getSourceAsMap().get("commentCount").toString();
            //discussPost.setCommentCount(Integer.valueOf(commentCount));

            // handle the text with high light
            HighlightField titleField = hit.getHighlightFields().get("title");
            if (titleField != null) {
                discussPost.setTitle(titleField.getFragments()[0].toString());
            }

            HighlightField contentField = hit.getHighlightFields().get("content");
            if (contentField != null) {
                discussPost.setContent(contentField.getFragments()[0].toString());
            }

            discussPosts.add(discussPost);
        }

        SearchResult searchResult = new SearchResult(discussPosts, total);
        return searchResult;
    }
}
