package com.hisun.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.hisun.common.bean.User;
import com.hisun.dao.UserDao;
import com.hisun.service.UserService;

@Repository
public class UserServiceImpl implements UserService
{

    @Resource
    private UserDao userDao;


    @Override
    public User selectByPrimaryKey(Long id)
    {
        return this.userDao.selectByPrimaryKey(id);   
    }

}
