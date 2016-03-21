package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.hisun.common.bean.User;
import com.hisun.dao.UserDao;
import com.hisun.service.UserService;

/**
 * 
 * @类名： UserServiceImpl.java
 * @描述：UserServiceImpl
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Repository
public class UserServiceImpl implements UserService
{

    @Resource
    private UserDao userDao;


    @Override
    public void insertUser(User user)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteUserById(Long id)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateUser(User User)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public User getUserById(Long id)
    {
        // TODO Auto-generated method stub
        return userDao.getUserById(id);
    }


    @Override
    public List<User> getAllUser()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<User> getUserByParams(Map<String, Object> params)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
