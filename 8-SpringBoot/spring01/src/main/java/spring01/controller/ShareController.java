package spring01.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.entity.Event;
import spring01.event.EventProducer;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: ShareController
 * Author:   Peter
 * Date:     05/04/2022 14:44
 * Description:
 * History:
 * Version:
 */

@Controller
public class ShareController implements CommunityConstant {

    private static final Logger logger = LoggerFactory.getLogger(ShareController.class);

    @Value("${community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${wk.image.storage}")
    private String wkImageStorage;

    @Value("${qiniu.bucket.share.url}")
    private String shareBucketUrl;

    @Autowired
    private EventProducer eventProducer;

    /**
     * 分享路径， 进行异步请求
     * @return
     */
    @RequestMapping(path = "/share", method = RequestMethod.GET)
    @ResponseBody
    public String share(String htmlUrl) {
        // filename
        String filename = CommunityUtil.generateUUID().replaceAll(" ", "_");
        // 异步请求， 需要构建event
        Event event = new Event()
                .setTopic(TOPIC_SHARE)
                .setData("htmlUrl", htmlUrl)
                .setData("filename", filename)
                .setData("suffix", ".png");
        eventProducer.fireEvent(event);

        // 返回访问路径
        Map<String, Object> map = new HashMap<>();
        // map.put("shareUrl", domain + contextPath + "/share/image/" + filename);
        map.put("sharUrl", shareBucketUrl + "/" + filename);

        return CommunityUtil.getJSONString(0, null, map);
    }

    @Deprecated
    @RequestMapping(path = "/share/image/{filename}", method = RequestMethod.GET)
    public void getShareImage(@PathVariable("filename") String filename, HttpServletResponse response) {
        if (StringUtils.isBlank(filename)) {
            throw new IllegalArgumentException("文件名不能为空");
        }

        response.setContentType("image/png");
        // 获取本地图片
        File file = new File(wkImageStorage + "/" + filename + ".png");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            logger.error("获取长图失败： " + e.getMessage());
        }
    }

}
