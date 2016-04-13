package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.exception.DataAccessException;
import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.PointActionDao;

/**
 * 
 * @类名： Album.java
 * 
 * @描述：Album @作者： PAUL @修改日期： 2016年3月20日
 *
 */
public class PointActionDaoTest extends AbstractJUnitTest
{

    @Resource
    private PointActionDao pointActionDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testPointActionDao()
    {
        System.out.println("hello world test...");
        try
        {
            System.out.println(pointActionDao.getPointActionById(1L));
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
