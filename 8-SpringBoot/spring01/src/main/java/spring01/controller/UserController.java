package spring01.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import spring01.annotation.LoginRequired;
import spring01.entity.Comment;
import spring01.entity.DiscussPost;
import spring01.entity.Page;
import spring01.entity.User;
import spring01.service.*;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;
import spring01.util.HostHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserController
 * Author:   Peter
 * Date:     16/03/2022 08:29
 * Description: 用户界面
 * History:
 * Version:
 */

@Controller
@RequestMapping("/user")
public class UserController implements CommunityConstant {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${community.path.upload}")
    private String uploadPath;

    @Value("${community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private LikeService likeService;

    @Autowired
    private FollowService followService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private DiscussPostService discussPostService;

    @LoginRequired
    @RequestMapping(path = "/setting", method = RequestMethod.GET)
    public String getSettingPage() {
        return "/site/setting";
    }

    @LoginRequired
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadHeader(MultipartFile headerImage, Model model) {
        if (headerImage == null) {
            model.addAttribute("error", "Have not select any images yet");
            return "/site/setting";
        }

        // 判断文件后缀
        String filename = headerImage.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if (StringUtils.isBlank(suffix)) {
            model.addAttribute("error", "Wrong  image format!");
            return "/site/setting";
        }

        // 生成随机文件名
        filename = CommunityUtil.generateUUID() + suffix;
        File dest = new File(uploadPath + "/" + filename); // 文件存放路径
        try {
            headerImage.transferTo(dest);
        } catch (IOException e) {
            logger.error("Unsuccessfully upload: " + e.getMessage());
            throw new RuntimeException("上传文件失败， 服务器异常", e);
        }

        // update the header url (web 访问路径)
        // http:localhost:8080/community/user/header/xxx.png
        User user = hostHolder.getUser();
        String headerUrl = domain + contextPath + "/user/header/" + filename;
        userService.updateHeader(user.getId(), headerUrl);

        return "redirect:/index";
    }

    /**
     * 返回名字 http:localhost:8080/community/user/header/xxx.png
     * @param filename
     * @param response
     */
    @RequestMapping(path = "/header/{filename}", method = RequestMethod.GET)
    public void getHeader(@PathVariable("filename") String filename, HttpServletResponse response) {
        // 服务器存放路径
        String filepath = uploadPath + "/" + filename;
        String suffix = filename.substring(filename.lastIndexOf("."));
        // 响应图片
        response.setContentType("image/" + suffix);

        FileInputStream fis = null;
        try {
            OutputStream os = response.getOutputStream(); // spring 可自动关闭
            fis = new FileInputStream(filepath);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            logger.error("读取图像失败" + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This controller object is going to achieve modifying password function.
     *
     * Firstly, we need to get the current user, then verify the input `oldPassword` is correct or not.
     * @return
     */
    @LoginRequired
    @RequestMapping(path = "/password", method = RequestMethod.POST)
    public String modifyPassword(Model model, String oldPassword, String newPassword, String confirmedPassword) {
        // check the post information
        if (StringUtils.isBlank(oldPassword)) {
            model.addAttribute("oldPasswordMsg", "The old password cannot be blank!");
            return "/site/setting";
        }
        if (StringUtils.isBlank(newPassword)) {
            model.addAttribute("newPasswordMsg", "The new password cannot be blank!");
            return "/site/setting";
        }
        if (StringUtils.isBlank(confirmedPassword)) {
            model.addAttribute("confirmedPasswordMsg", "The confirmed password cannot be blank!");
            return "/site/setting";
        }

        // get the current user
        User user = hostHolder.getUser();

        // verify the oldPassword
        oldPassword = CommunityUtil.md5(oldPassword + user.getSalt());
        if (!oldPassword.equals(user.getPassword())) {
            model.addAttribute("oldPasswordMsg", "The old password is not correct!");
            return "/site/setting";
        }

        // verify the new password
        if (!newPassword.equals(confirmedPassword)) {
            model.addAttribute("confirmedPasswordMsg", "The confirmed password is not correct!");
            return "/site/setting";
        }

        // modify the password
        newPassword = CommunityUtil.md5(newPassword + user.getSalt());
        userService.modifyPassword(user.getId(), newPassword);

        return "redirect:/index";
    }

    @RequestMapping(path = "/profile/{userId}", method = RequestMethod.GET)
    public String getProfilePage(@PathVariable("userId") int userId, Model model) {
        User user = userService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("该用户不存在");
        }

        // 用户基本信息
        model.addAttribute("user", user);
        // like count
        int likeCount = likeService.findUserLikeCount(userId);
        model.addAttribute("likeCount", likeCount);
        // 粉丝和关注人数量
        long followeeCount = followService.findFolloweeCount(userId, ENTITY_TYPE_USER);
        model.addAttribute("followeeCount", followeeCount);
        long followerCount = followService.findFollowerCount(ENTITY_TYPE_USER, userId);
        model.addAttribute("followerCount", followerCount);
        boolean hasFollowed = false;
        if (hostHolder.getUser() != null) {
            hasFollowed = followService.hasFollowed(hostHolder.getUser().getId(), ENTITY_TYPE_USER, userId);
        }
        model.addAttribute("hasFollowed", hasFollowed);

        return "/site/profile";
    }

    /**
     * 个人页面中， 我的回复功能
     * @param model
     * @param page
     * @return
     */
    @LoginRequired
    @RequestMapping(path = "/myreply/{userId}", method = RequestMethod.GET)
    public String getPostReplyPage(@PathVariable("userId") int userId, Model model, Page page) {
        User user = userService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("该用户不存在！");
        }
        model.addAttribute("user", user);

        // 设置页面信息
        page.setLimit(10);
        page.setPath("/user/myreply/" + userId);
        int commentCount = commentService.findCommentsCountByUserIdForPost(user.getId());
        page.setRows(commentCount);
        model.addAttribute("totalCommentNum", commentCount); // 回复帖子数量

        // 查询当前用户的回帖信息
        List<Comment> commentList = commentService.findCommentsByUserIdForPost(user.getId(), page.getOffset(),
                page.getLimit());

        // 利用回帖信息， 提取回帖
        List<Map<String, Object>> replyVoList = new ArrayList<>();  // 存储每一个回复对应的信息
        for (Comment comment : commentList) {
            Map<String, Object> replyVo = new HashMap<>(); // 单条信息储存单元

            replyVo.put("comment", comment);  // can get content and create time
            DiscussPost discussPost = discussPostService.findDiscussPostById(comment.getEntityId());
            replyVo.put("discussPost", discussPost);

            replyVoList.add(replyVo);
        }

        model.addAttribute("replyVoList", replyVoList);

        return "/site/my-reply";
    }
}
