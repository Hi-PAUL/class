package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.NoticeDao;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class NoticeDaoTest extends AbstractJUnitTest
{

    @Resource
    private NoticeDao noticeDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testNoticeDao()
    {
        System.out.println("hello world test...");
        System.out.println(noticeDao.getNoticeById(1L));
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}
