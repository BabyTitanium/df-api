package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.News;
import com.dongfan.dongfanapi.entity.NewsType;
import com.dongfan.dongfanapi.mapper.NewsMapper;
import com.dongfan.dongfanapi.mapper.NewsTypeMapper;
import com.dongfan.dongfanapi.service.NewsService;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/18 17:37
 * @Version 1.0
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsTypeMapper newsTypeMapper;
    @Resource
    NewsMapper newsMapper;
    @Override
    public void addNewsType(NewsType newsType) {
        newsTypeMapper.insertSelective(newsType);
    }

    @Override
    public void deleteNewType(int id) {
        newsTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editNewsType(NewsType newsType) {
        newsTypeMapper.updateByPrimaryKey(newsType);
    }

    @Override
    public List<NewsType> getNewsTypeList(Map condition) {
        PageUtil.pageCondition(condition);
        return newsTypeMapper.getNewsTypeList(condition);
    }

    @Override
    public List<News> getNewsList(int typeId, int page, int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return newsMapper.getNewsList(typeId,pageStart,pageSize);
    }

    @Override
    public void deleteNews(int id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public News getNews(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addNews(News news) {
        newsMapper.insertSelective(news);
    }

    @Override
    public void editNews(News news) {
        newsMapper.updateByPrimaryKeySelective(news);
    }
}
