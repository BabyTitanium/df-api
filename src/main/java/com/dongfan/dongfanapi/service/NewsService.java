package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.News;
import com.dongfan.dongfanapi.entity.NewsType;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/18 17:37
 * @Version 1.0
 */
public interface NewsService {
    void addNewsType(NewsType newsType);
    void deleteNewType(int id);
    void editNewsType(NewsType newsType);
    List<NewsType> getNewsTypeList(Map condition);
    List<News> getNewsList(int typeId,int page,int pageSize);
    void deleteNews(int id);
    News getNews(int id);
    void addNews(News news);
    void editNews(News news);
}
