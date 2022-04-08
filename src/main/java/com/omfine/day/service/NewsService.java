package com.omfine.day.service;

import com.omfine.day.bean.News;
import java.util.List;

public interface NewsService {

    List<News> getAll();

    int insert(News news);
}
