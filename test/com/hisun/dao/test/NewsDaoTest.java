package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.exception.DataAccessException;
import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.NewsDao;

/**
 * 
 * @类名： NewsDaoTest.java
 * 
 * @描述：NewsDaoTest @作者： PAUL @修改日期： 2016年5月10日
 *
 */
public class NewsDaoTest extends AbstractJUnitTest
{

    @Resource
    private NewsDao newsDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testNewsDao()
    {
        System.out.println("hello world test...");

        try
        {
            System.out.println(newsDao.getAllNews());
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}
