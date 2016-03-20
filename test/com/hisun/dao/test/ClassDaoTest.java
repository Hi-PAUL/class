package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.ClassDao;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class ClassDaoTest extends AbstractJUnitTest
{

    @Resource
    private ClassDao classDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testClassDao()
    {
        System.out.println("hello world test...");
        System.out.println(classDao.selectByPrimaryKey(1L));
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}