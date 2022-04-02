package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring01.entity.DiscussPost;
import spring01.entity.Page;
import spring01.entity.SearchResult;
import spring01.service.ElasticsearchService;
import spring01.service.LikeService;
import spring01.service.UserService;
import spring01.util.CommunityConstant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName:    SearchController
 *
 * @Author: Peter
 * Date:        01/04/2022 12:23
 * Description:  针对查询界面
 * History:
 * Version:
 */

@Controller
public class SearchController implements CommunityConstant {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    /**
     * 搜索界面controller
     * <p>
     * 搜索url: /search?keyword=xxx
     *
     * @param keyword
     * @param model
     * @param page
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String search(String keyword, Model model, Page page) {
        // 搜索帖子
        SearchResult searchResult = null;
        try {
            searchResult = elasticsearchService.searchDiscussPost(keyword, page.getCurrent() - 1, page.getLimit());
        } catch (IOException e) {
            model.addAttribute("searchMsg", "服务器错误");
            e.printStackTrace();
        }

        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (searchResult != null) {
            for (DiscussPost post : searchResult.getPosts()) {
                Map<String, Object> map = new HashMap<>(16);

                map.put("post", post);
                // 发帖人
                map.put("user", userService.findUserById(post.getUserId()));
                // 点赞数
                map.put("likeCount", likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId()));

                discussPosts.add(map);
            }
        }

        model.addAttribute("discussPosts", discussPosts);
        model.addAttribute("keyword", keyword);

        // set page
        page.setPath("/search?keyword=" + keyword);
        page.setRows(searchResult == null ? 0 : (int) searchResult.getTotal());

        return "/site/search";
    }
}
