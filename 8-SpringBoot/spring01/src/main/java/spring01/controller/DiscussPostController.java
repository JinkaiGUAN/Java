package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring01.entity.*;
import spring01.event.EventProducer;
import spring01.service.CommentService;
import spring01.service.DiscussPostService;
import spring01.service.LikeService;
import spring01.service.UserService;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

import java.util.*;

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
public class DiscussPostController implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    /**
     * 获取当前用户
     */
    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private EventProducer eventProducer;

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

        // 触发发帖事件
        Event event = new Event()
                .setTopic(TOPIC_PUBLISH)
                .setUserId(user.getId())
                .setEntityType(ENTITY_TYPE_POST)
                .setEntityId(discussPost.getId());
        eventProducer.fireEvent(event);

        // 报错的情况 将来统一处理
        return CommunityUtil.getJSONString(0, "发布成功！");
    }

    /**
     * 查询帖子详情
     *
     * s实体类会自动存入model中
     * @param discussPostId: 在discuss post表单中的id
     * @param model
     * @param page: 表单页
     * @return
     */
    @RequestMapping(path = "/detail/{discussPostId}", method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model, Page page) {
        // 查询帖子信息
        DiscussPost discussPost = discussPostService.findDiscussPostById(discussPostId);
        // 在页面使用${post.title} 会自动调用响应的get方法
        model.addAttribute("post", discussPost);
        // 作者信息
        User user = userService.findUserById(discussPost.getUserId());
        model.addAttribute("user", user);
        // 点赞数量
        long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, discussPostId);
        model.addAttribute("likeCount", likeCount);
        // 点赞状态
        int likeStatus = hostHolder.getUser() != null ? likeService.findEntityLikeStatus(hostHolder.getUser().getId(),
                ENTITY_TYPE_POST, discussPostId) : 0;
        model.addAttribute("likeStatus", likeStatus);

        // 评论信息
        page.setLimit(5);
        page.setPath("/discuss/detail/" +  discussPostId);
        page.setRows(discussPost.getCommentCount());

        // 评论列表
        List<Comment> commentList = commentService.findCommentsByEntity(ENTITY_TYPE_POST, discussPost.getId(),
                page.getOffset(), page.getLimit());
        // 评论VO（view object）列表
        List<Map<String, Object>> commentVoList = new ArrayList<>();
        if (commentList != null) {
            for (Comment comment : commentList) {
                // 评论VO
                Map<String, Object> commentVo = new HashMap<>();
                // 评论
                commentVo.put("comment", comment);
                // 作者
                commentVo.put("user", userService.findUserById(comment.getUserId()));
                // 点赞数量
                likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_COMMENT, comment.getId());
                commentVo.put("likeCount", likeCount);
                // 点赞状态
                likeStatus = hostHolder.getUser() != null ? likeService.findEntityLikeStatus(hostHolder.getUser().getId(),
                        ENTITY_TYPE_COMMENT, comment.getId()) : 0;
                commentVo.put("likeStatus", likeStatus);

                // 回复列表
                List<Comment> replyList = commentService.findCommentsByEntity(ENTITY_TYPE_COMMENT, comment.getId(), 0
                        , Integer.MAX_VALUE);
                // 回复VO
                List<Map<String, Object>> replyVoList = new ArrayList<>();
                if (replyList != null) {
                    for (Comment reply : replyList) {
                        Map<String, Object> replyVo = new HashMap<>();
                        // 回复
                        replyVo.put("reply", reply);
                        // 作者
                        replyVo.put("user", userService.findUserById(reply.getUserId()));
                        // 回复目标
                        User target = reply.getTargetId() == 0 ? null : userService.findUserById(reply.getTargetId());
                        replyVo.put("target", target);
                        // 点赞数量
                        likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_COMMENT, reply.getId());
                        replyVo.put("likeCount", likeCount);
                        // 点赞状态
                        likeStatus = hostHolder.getUser() != null ? likeService.findEntityLikeStatus(hostHolder.getUser().getId(),
                                ENTITY_TYPE_COMMENT, reply.getId()) : 0;
                        replyVo.put("likeStatus", likeStatus);

                        replyVoList.add(replyVo);
                    }
                }
                commentVo.put("replys", replyVoList);

                // 回复数量
                int replyCount = commentService.findCommentCount(ENTITY_TYPE_COMMENT, comment.getId());
                commentVo.put("replyCount", replyCount);

                commentVoList.add(commentVo);
            }
        }

        model.addAttribute("comments", commentVoList);

        return "/site/discuss-detail";
    }

    /**
     * 设置置顶。
     *
     * 需要从页面传数据， 而且页面整体不刷新， 所以使用POST
     * @param id
     * @return
     */
    @RequestMapping(path = "/top", method = RequestMethod.POST)
    @ResponseBody
    public String setTop(int id){
        discussPostService.updateType(id, DISCUSS_TYPE_TOP);

        // 在更新完帖子状态之后， ES中也要进行更新， 因此得触发发帖事件
        Event event = new Event()
                .setTopic(TOPIC_PUBLISH)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);

        return CommunityUtil.getJSONString(0);
    }

    /**
     * 设置精华帖。
     *
     * 需要从页面传数据， 而且页面整体不刷新， 所以使用POST
     * @param id
     * @return
     */
    @RequestMapping(path = "/wonderful", method = RequestMethod.POST)
    @ResponseBody
    public String setWonderful(int id){
        discussPostService.updateStatus(id, DISCUSS_STATUS_WONDERFUL);

        // 在更新完帖子状态之后， ES中也要进行更新， 因此得触发发帖事件
        Event event = new Event()
                .setTopic(TOPIC_PUBLISH)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);

        return CommunityUtil.getJSONString(0);
    }

    /**
     * 删除帖子。
     *
     * 需要从页面传数据， 而且页面整体不刷新， 所以使用POST
     * @param id
     * @return
     */
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        discussPostService.updateStatus(id, DISCUSS_STATUS_BLOCK);

        // 设置拉黑（删除）之后， ES中不应该存在该贴信息， 所以要触发删帖事件
        Event event = new Event()
                .setTopic(TOPIC_DELETE)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);

        return CommunityUtil.getJSONString(0);
    }
}
