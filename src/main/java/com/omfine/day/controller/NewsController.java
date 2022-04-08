package com.omfine.day.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.day.bean.News;
import com.omfine.day.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewsController {

    @Resource
    private NewsService service = null;

    @RequestMapping("/all")
    @ResponseBody
    public String getAllNews(){
        List<News> news = service.getAll();
        String newsJson = JSON.toJSONString(news);
        System.err.println(newsJson);
        return newsJson;
    }

    @RequestMapping("/addNews")
    public String addNews(News news, Model model){
        System.err.println(JSON.toJSONString(news));
        if (null != news.title){
            long cTime = System.currentTimeMillis();
            news.setCTime(cTime);
            news.setUpdateTimestamp(cTime);
            int result = service.insert(news);
            model.addAttribute("result" ,  1 == result ? "add Success" : "add Failed");
        }
        return "news_add";
    }



}
