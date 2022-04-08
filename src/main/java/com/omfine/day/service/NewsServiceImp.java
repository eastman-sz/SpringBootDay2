package com.omfine.day.service;

import com.omfine.day.bean.News;
import com.omfine.day.mapper.NewsMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class NewsServiceImp implements NewsService{

    @Resource
    private NewsMapper mapper = null;

    @Override
    public int insert(News news) {
        return mapper.insert(news);
    }

    @Override
    public List<News> getAll() {
        return mapper.selectList(null);
    }



}
