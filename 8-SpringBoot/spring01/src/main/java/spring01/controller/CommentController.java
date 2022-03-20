package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring01.entity.Comment;
import spring01.service.CommentService;
import spring01.util.HostHolder;

import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: CommentController
 * Author:   Peter
 * Date:     20/03/2022 08:56
 * Description:
 * History:
 * Version:
 */

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/add/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") String discussPostId, Comment comment) {
        //fixme: 用户未登录 不能访问
        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());

        // content 会被自动加入 因为在html页面中引用了comment.content属性
        commentService.addComment(comment);

        return "redirect:/discuss/detail/" + discussPostId;
    }
}
