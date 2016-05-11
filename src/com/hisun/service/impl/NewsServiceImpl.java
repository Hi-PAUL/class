package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hisun.common.bean.News;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.NewsServiceException;
import com.hisun.dao.NewsDao;
import com.hisun.service.NewsService;

/**
 * 
 * @类名： NewsServiceImpl.java
 * 
 * @描述：NewsServiceImpl @作者： PAUL @修改日期： 2016年5月10日
 *
 */
@Repository
public class NewsServiceImpl implements NewsService
{
    @Resource
    private NewsDao newsDao;


    @Override
    public void insertNews(News news) throws NewsServiceException
    {

    }


    @Override
    public void deleteNewsById(Long id) throws NewsServiceException
    {
        try
        {
            this.newsDao.deleteNewsById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updateNews(News news) throws NewsServiceException
    {

    }


    @Override
    public News getNewsById(Long id) throws NewsServiceException
    {
        News news = null;
        try
        {
            news = this.newsDao.getNewsById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return news;
    }


    @Override
    public List<News> getNewsByNode(String node) throws NewsServiceException
    {
        List<News> list = null;
        try
        {
            list = this.newsDao.getNewsByNode(node);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<News> getAllNews() throws NewsServiceException
    {
        return null;
    }


    @Override
    public Map<String, Object> getNewsList(Integer pageNumber, Integer pageSize, String publisher, String title, String node) throws NewsServiceException
    {

        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(publisher))
        {
            params.put("publisher", publisher);
        }
        if (StringUtils.isNotEmpty(title))
        {
            params.put("title", title);
        }
        if (StringUtils.isNotEmpty(node))
        {
            params.put("node", node);
        }

        List<News> messageList = null;
        try
        {
            messageList = this.newsDao.getNewsByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = messageList.size() < fromRecord + pageSize ? messageList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", messageList == null ? null : messageList.subList(fromRecord, endRecord));
        map.put("total", messageList == null ? 0 : messageList.size());
        return map;
    }


    @Override
    public void saveNewsInfo(Long id, String publisher, String node, String title, String content) throws NewsServiceException
    {
        News news = null;
        try
        {
            news = (id == null ? new News() : this.newsDao.getNewsById(id));
            news.setPublisher(publisher);
            news.setTitle(title);
            news.setNode(node);
            news.setContent(content);
            if (id == null)
            {
                news.setDateline(new Date());
                this.newsDao.insertNews(news);
            }
            else
            {
                this.newsDao.updateNews(news);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

}
