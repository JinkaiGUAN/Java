package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.entity.Event;
import spring01.entity.User;
import spring01.event.EventProducer;
import spring01.service.LikeService;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: LikeController
 * Author:   Peter
 * Date:     24/03/2022 19:33
 * Description:
 * History:
 * Version:
 */

@Controller
public class LikeController implements CommunityConstant {

    @Autowired
    private LikeService likeService;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 点赞
     * @param entityType
     * @param entityId
     * @param entityUserId
     * @param postId： 帖子id
     * @return
     */
    @RequestMapping(path = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId, int postId) {
        User user = hostHolder.getUser();

        // 点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);
        // 数量
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
        // 状态
        int likeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);

        Map<String, Object> map = new HashMap<>(16);
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);

        // 触发点在事件 - 取消点赞时不触发
        if (likeStatus == 1) {
            Event event = new Event()
                    .setTopic(TOPIC_LIKE)
                    .setUserId(hostHolder.getUser().getId())
                    .setEntityType(entityType)
                    .setEntityId(entityId)
                    .setEntityUserid(entityUserId)
                    .setData("postId", postId);
            eventProducer.fireEvent(event);
        }

        return CommunityUtil.getJSONString(0, null, map);
    }
}
