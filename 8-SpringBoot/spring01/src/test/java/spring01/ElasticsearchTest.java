package spring01;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.dao.DiscussPostMapper;
import spring01.dao.elasticsearch.DiscussPostRepository;
import spring01.entity.DiscussPost;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: ElasticsearchTest
 *
 * @Author: Peter
 * Date:     31/03/2022 19:58
 * Description:
 * History:
 * Version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
public class ElasticsearchTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private DiscussPostRepository discussPostRepository;

    // The client function
    @Qualifier("client")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testInsert() {
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(241));
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(242));
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(243));
    }

    @Test
    public void testInsertList() {
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(101, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(102, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(103, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(111, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(112, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(131, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(132, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(133, 0, 100, 0));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(134, 0, 100, 0));
    }

    @Test
    public void testUpdate() {
        DiscussPost discussPost = discussPostMapper.selectDiscussPostById(231);
        discussPost.setContent("??????????????? ????????????");
        discussPostRepository.save(discussPost);
    }

    @Test
    public void testDelete() {
        discussPostRepository.deleteById(231);
    }

    @Test
    public void testSearch() throws IOException {
        // ???????????????

        SearchRequest searchRequest = new SearchRequest("discusspost");//discusspost???????????????????????????

        //??????????????????
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                //???discusspost?????????title???content???????????????????????????????????????
                .query(QueryBuilders.multiMatchQuery("???????????????", "title", "content"))
                // matchQuery????????????????????????key???????????????searchSourceBuilder.query(QueryBuilders.matchQuery(key,value));
                // termQuery??????????????????searchSourceBuilder.query(QueryBuilders.termQuery(key,value));
                .sort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                //??????????????????????????????????????????????????????searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
                .from(0)// ???????????????????????????
                .size(10);// ??????????????????????????????

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(JSONObject.toJSON(searchResponse));

        List<DiscussPost> list = new LinkedList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            DiscussPost discussPost = JSONObject.parseObject(hit.getSourceAsString(), DiscussPost.class);
            System.out.println(discussPost);
            list.add(discussPost);
        }

    }

    @Test
    public void testSearchByTemplate() throws IOException {
        SearchRequest searchRequest = new SearchRequest("discusspost"); // discusspost???????????????????????????

        //??????
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.field("content");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");

        //??????????????????
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.multiMatchQuery("???????????????", "title", "content"))
                .sort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .sort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .from(0) // ???????????????????????????
                .size(10)// ??????????????????????????????
                .highlighter(highlightBuilder);//??????

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<DiscussPost> list = new LinkedList<>();
        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits().value;
        for (SearchHit hit : searchResponse.getHits()) {
            DiscussPost discussPost = JSONObject.parseObject(hit.getSourceAsString(), DiscussPost.class);

            // ???????????????????????????
            HighlightField titleField = hit.getHighlightFields().get("title");
            if (titleField != null) {
                discussPost.setTitle(titleField.getFragments()[0].toString());
            }
            HighlightField contentField = hit.getHighlightFields().get("content");
            if (contentField != null) {
                discussPost.setContent(contentField.getFragments()[0].toString());
            }
            System.out.println(discussPost);
            list.add(discussPost);
        }
    }

}
