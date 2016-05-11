package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.News;
import com.hisun.common.exception.NewsServiceException;

/**
 * 
 * @类名： NewsService.java
 * 
 * @描述：NewsService @作者： PAUL @修改日期： 2016年5月10日
 *
 */
@Service
public interface NewsService
{

    void insertNews(News news) throws NewsServiceException;


    void deleteNewsById(Long id) throws NewsServiceException;


    void updateNews(News news) throws NewsServiceException;


    News getNewsById(Long id) throws NewsServiceException;


    List<News> getNewsByNode(String node) throws NewsServiceException;


    List<News> getAllNews() throws NewsServiceException;


    Map<String, Object> getNewsList(Integer pageNumber, Integer pageSize, String publisher, String title, String node) throws NewsServiceException;


    void saveNewsInfo(Long id, String publisher, String node, String title, String content) throws NewsServiceException;
}
