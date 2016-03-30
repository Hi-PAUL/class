package com.hisun.dao.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hisun.common.bean.User;
import com.hisun.common.test.AbstractJUnitTest;
import com.hisun.dao.UserDao;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class UserDaoTest extends AbstractJUnitTest
{

    @Resource
    private UserDao userDao;


    @Before
    public void init()
    {
        System.out.println("----> init...");
    }


    @Test
    public void testUserDao()
    {
        System.out.println("hello world test...");
        User user = userDao.getUserById(1L);
        System.out.println(user);
    }
    
    @Test
    public void testGetUserByParams()
    {
        System.out.println("hello world test...");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isonline", 1);
        params.put("classid", 1);
        System.out.println(userDao.getUserByParams(params));
    }


    @After
    public void destory()
    {
        System.out.println("-----> destory...");
    }

}
