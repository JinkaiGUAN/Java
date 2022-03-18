package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.entity.DiscussPost;
import spring01.entity.User;
import spring01.service.DiscussPostService;
import spring01.service.UserService;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: DiscussPostController
 * Author:   Peter
 * Date:     17/03/2022 18:13
 * Description: 与帖子相关的视图
 * History:
 * Version:
 */

@Controller
@RequestMapping("/discuss")
public class DiscussPostController {

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private HostHolder hostHolder; // 获取当前用户
    @Autowired
    private UserService userService;

    /**
     * 发布帖子
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title, String content){
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "你还没有登录！");
        }

        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(user.getId());
        discussPost.setTitle(title);
        discussPost.setContent(content);
        discussPost.setCreateTime(new Date());
        discussPostService.addDiscussPost(discussPost);

        System.out.println("请求成功");

        // 报错的情况 将来统一处理
        return CommunityUtil.getJSONString(0, "发布成功！");
    }

    /**
     * 查询帖子详情
     * @param discussPostId
     * @param model
     * @return
     */
    @RequestMapping(path = "/detail/{discussPostId}", method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model) {
        // 查询帖子信息
        DiscussPost discussPost = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", discussPost); // 在页面使用${post.title} 会自动调用响应的get方法
        // 作者信息
        User user = userService.findUserById(discussPostId);
        model.addAttribute("user", user);

        //todo: 回复功能

        return "/site/discuss-detail";
    }



}
