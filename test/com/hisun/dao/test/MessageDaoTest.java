package com.hisun.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.MessageDao;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class MessageDaoTest extends AbstractJUnitTest
{

    @Resource
    private MessageDao messageDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testMessageDao()
    {
        System.out.println("hello world test...");
        System.out.println(messageDao.getMessageById(1L));
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}
