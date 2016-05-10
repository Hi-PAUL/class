package com.hisun.service.impl;

import java.util.List;

import javax.annotation.Resource;

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

    }


    @Override
    public void updateNews(News news) throws NewsServiceException
    {

    }


    @Override
    public News getNewsById(Long id) throws NewsServiceException
    {
        return null;
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

}
