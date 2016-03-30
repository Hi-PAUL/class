package com.hisun.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.UserServiceException;
import com.hisun.common.util.EmailUtil;
import com.hisun.common.util.MD5;
import com.hisun.common.util.RandomChar;
import com.hisun.dao.UserDao;
import com.hisun.service.UserService;

/**
 * 
 * @类名： UserServiceImpl.java
 * 
 * @描述：UserServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class UserServiceImpl implements UserService
{

    @Resource
    private UserDao userDao;


    @Override
    public User login(String username, String password) throws UserServiceException
    {
        User user = null;
        try
        {
            user = userDao.getUserByUsername(username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        if (user == null)
        {
            throw new UserServiceException("该账号不存在!");
        }
        if (!MD5.jdkMD5(password).equals(user.getPassword()))
        {
            throw new UserServiceException("该密码不正确!");
        }
        if (user.getStatus() == 0)
        {
            throw new UserServiceException("账号未激活,请前往邮箱激活!");
        }
        if (user.getStatus() == 2)
        {
            throw new UserServiceException("账号已被冻结,请与管理员联系!");
        }

        user.setIsonline(1);
        user.setLaterdate(new Date());
        userDao.updateUser(user);
        return user;

    }


    @Override
    public void register(String username, String password, String email) throws UserServiceException
    {

        User user = null;
        try
        {
            user = userDao.getUserByUsername(username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        if (user != null)
        {
            throw new UserServiceException("该账号已存在!");
        }
        user = new User();
        user.setUsername(username);
        user.setPassword(MD5.jdkMD5(password));
        user.setEmail(email);
        user.setRegisterdate(new Date());
        user.setIsonline(0);
        user.setStatus(0);
        String cdKey = RandomChar.getChars(4, 32);
        user.setCdkey(cdKey);
        System.out.println(username);
        System.out.println(email);
        System.out.println(cdKey);
        try
        {
            EmailUtil.sendEmail(username, email, cdKey);
        }
        catch (Exception e)
        {
            throw new UserServiceException(e.getMessage());
        }
        userDao.insertUser(user);
    }


    @Override
    public User activate(String username, String cdKey) throws UserServiceException
    {
        User user = null;
        try
        {
            user = userDao.getUserByUsername(username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        if (user == null)
        {
            throw new UserServiceException("该账号不存在!");
        }
        if (!cdKey.equals(user.getCdkey()))
        {
            throw new UserServiceException("激活码不正确!");
        }
        user.setIsonline(1);
        user.setStatus(1);
        user.setRegisterdate(new Date());
        userDao.updateUser(user);
        return user;
    }


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
        return userDao.getUserById(id);
    }


    @Override
    public User getUserByUsername(String username) throws UserServiceException
    {
        User user = null;
        try
        {
            user = userDao.getUserByUsername(username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return user;
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
