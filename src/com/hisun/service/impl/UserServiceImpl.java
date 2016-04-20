package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.UserServiceException;
import com.hisun.common.util.EmailUtil;
import com.hisun.common.util.MD5;
import com.hisun.common.util.RandomChar;
import com.hisun.dao.PointActionDao;
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

    @Resource
    private PointActionDao pointActionDao;


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
        Date lastDate = user.getLaterdate();
        Date newDate = new Date();
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        if (newDate.getTime() - lastDate.getTime() > nd)
        {
            try
            {   // 超过一天登陆送积分
                Integer point = this.pointActionDao.getPointActionByActionname("LOGIN");
                user.setPoint(user.getPoint() + point);
            }
            catch (DataAccessException e)
            {
                e.printStackTrace();
            }
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
        try
        {
            Integer point = this.pointActionDao.getPointActionByActionname("REGISTER");
            user.setPoint(Long.valueOf(point));
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        try
        {
            EmailUtil.sendEmail(username, email, cdKey);//发送邮箱激活码
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
    public void deleteUserById(Long id) throws UserServiceException
    {
        try
        {
            this.userDao.deleteUserById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void updateUser(User user)
    {
        this.userDao.updateUser(user);

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
    public List<User> getUserByParams(int isonline, Long classid) throws UserServiceException
    {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isonline", isonline);
        params.put("classid", classid);
        List<User> list = null;
        try
        {
            list = userDao.getUserByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Map<String, Object> getUserList(Integer pageNumber, Integer pageSize, String username, String name, Long classid) throws UserServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (classid != null)
        {
            params.put("classid", classid);
        }
        if (StringUtils.isNotEmpty(username))
        {
            params.put("username", username);
        }
        if (StringUtils.isNotEmpty(name))
        {
            params.put("name", name);
        }
        List<User> userList = null;
        try
        {
            userList = this.userDao.getUserByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = userList.size() < fromRecord + pageSize ? userList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", userList == null ? null : userList.subList(fromRecord, endRecord));
        map.put("total", userList == null ? 0 : userList.size());
        return map;
    }


    @Override
    public void saveUseInfo(Long id, String username, String sex, String qq, String phone, String email, Integer status, Long point, String name, String studentid) throws UserServiceException
    {
        User user = null;
        try
        {
            user = (id == null ? new User() : this.userDao.getUserById(id));
            user.setUsername(username);
            user.setSex(sex);
            user.setQq(qq);
            user.setPhone(phone);
            user.setEmail(email);
            user.setStatus(status);
            user.setPoint(point);
            user.setName(name);
            user.setStudentid(studentid);
            if (id == null)
            {
                if (this.userDao.getUserByUsername(username) != null)
                {
                    throw new UserServiceException("该账号已经存在！");
                }
                this.userDao.insertUser(user);
            }
            else
            {
                this.userDao.updateUser(user);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }

}
