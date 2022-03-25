package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.annotation.LoginRequired;
import spring01.entity.Page;
import spring01.entity.User;
import spring01.service.FollowService;
import spring01.service.UserService;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: FollowController
 * Author:   Peter
 * Date:     25/03/2022 18:52
 * Description:
 * History:
 * Version:
 */

@Controller
public class FollowController implements CommunityConstant {

    @Autowired
    private FollowService followService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @LoginRequired
    @RequestMapping(path ="/follow", method = RequestMethod.POST)
    @ResponseBody
    public String follow(int entityTYpe, int entityId) {
        User user = hostHolder.getUser();

        followService.follow(user.getId(), entityTYpe, entityId);

        return CommunityUtil.getJSONString(0, "已关注！");
    }

    @LoginRequired
    @RequestMapping(path ="/unfollow", method = RequestMethod.POST)
    @ResponseBody
    public String unfollow(int entityTYpe, int entityId) {
        User user = hostHolder.getUser();

        followService.unfollow(user.getId(), entityTYpe, entityId);

        return CommunityUtil.getJSONString(0, "已取消关注！");
    }

    @RequestMapping(path = "/followees/{userId}", method = RequestMethod.GET)
    public String getFollowees(@PathVariable("userId") int userId, Page page, Model model) {
        User user = userService.findUserById(userId);

        if (user == null) {
            throw new IllegalArgumentException("用户不存在！");
        }
        model.addAttribute("user", user);

        // page configuration
        page.setLimit(5);
        page.setPath("/followees/" + userId);
        page.setRows((int) followService.findFolloweeCount(userId, ENTITY_TYPE_USER));

        // get the data
        List<Map<String, Object>> userList = followService.findFollowees(userId, page.getOffset(), page.getLimit());
        if (userList != null) {
            for (Map<String, Object> map : userList) {
                User u = (User) map.get("user");
                map.put("hasFollowed", hasFollowed(u.getId()));
            }
        }
        model.addAttribute("users", userList);

        return "/site/followee";
    }

    @RequestMapping(path = "/followers/{userId}", method = RequestMethod.GET)
    public String getFollowers(@PathVariable("userId") int userId, Page page, Model model) {
        User user = userService.findUserById(userId);

        if (user == null) {
            throw new IllegalArgumentException("用户不存在！");
        }
        model.addAttribute("user", user);

        // page configuration
        page.setLimit(5);
        page.setPath("/followers/" + userId);
        page.setRows((int) followService.findFollowerCount(ENTITY_TYPE_USER, userId));

        // get the data
        List<Map<String, Object>> userList = followService.findFollowers(userId, page.getOffset(), page.getLimit());
        if (userList != null) {
            for (Map<String, Object> map : userList) {
                User u = (User) map.get("user");
                map.put("hasFollowed", hasFollowed(u.getId()));
            }
        }
        model.addAttribute("users", userList);

        return "/site/follower";
    }

    private boolean hasFollowed(int userId) {
        if (hostHolder.getUser() == null) {
            return false;
        }
        return followService.hasFollowed(hostHolder.getUser().getId(), ENTITY_TYPE_USER, userId);
    }
}
