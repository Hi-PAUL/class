package com.hisun.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.News;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： NewsDao.java
 * 
 * @描述：NewsDao @作者： PAUL @修改日期： 2016年5月10日
 *
 */
@Repository
public interface NewsDao
{

    void insertNews(News news) throws DataAccessException;


    void deleteNewsById(Long id) throws DataAccessException;


    void updateNews(News news) throws DataAccessException;


    News getNewsById(Long id) throws DataAccessException;


    List<News> getNewsByNode(String node) throws DataAccessException;


    List<News> getAllNews() throws DataAccessException;
}
