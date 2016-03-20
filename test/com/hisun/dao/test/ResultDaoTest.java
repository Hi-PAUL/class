package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.ResultDao;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class ResultDaoTest extends AbstractJUnitTest
{

    @Resource
    private ResultDao resultDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testUserDao()
    {
        System.out.println("hello world test...");
        System.out.println(resultDao.selectByPrimaryKey(1L));
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}
