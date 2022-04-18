package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring01.service.DataStatisticsService;

import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: DataStatisticsController
 * Author:   Peter
 * Date:     04/04/2022 10:55
 * Description: 显示数据界面
 * History:
 * Version:
 * @author Peter
 */

@Controller
public class DataStatisticsController {

    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**
     * 获取统计页面
     *
     * 本来可以定义为Get， 但是我们下方用转发的原始请求为POST， 并且请求事不能狗改变， 所以此处也要支持POST请求。
     * @return
     */
    @RequestMapping(path = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDataPage() {
        return "/site/admin/data";
    }

    /**
     * 统计独立访客
     * @param start
     * @param end
     * @param model
     * @return
     */
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long uv = dataStatisticsService.calculateUV(start, end);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);

        // 可以复用getPage处的逻辑
        return "forward:/data";
        //return "/site/admin/data";
    }


    //@RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    //public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
    //                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
    //    long dau = dataStatisticsService.calculateDAU(start, end);
    //    model.addAttribute("deuResult", dau);
    //    model.addAttribute("dauStartDate", start);
    //    model.addAttribute("dauEndDate", end);
    //
    //    // 可以复用getPage处的逻辑
    //    //return "/site/admin/data";
    //    return "forward:/data";
    //}

    /**
     * 统计日活跃用户
     * @param start
     * @param end
     * @param model
     * @return
     */
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long dau = dataStatisticsService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);
        return "forward:/data";
    }
}
