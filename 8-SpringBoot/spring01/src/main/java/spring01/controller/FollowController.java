package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.annotation.LoginRequired;
import spring01.entity.User;
import spring01.service.FollowService;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

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
public class FollowController {

    @Autowired
    private FollowService followService;

    @Autowired
    private HostHolder hostHolder;

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
}
