package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Admin;
import com.hisun.common.exception.AdminServiceException;
import com.hisun.common.exception.DataAccessException;
import com.hisun.dao.AdminDao;
import com.hisun.service.AdminService;

/**
 * 
 * @类名： AdminServiceImpl.java
 * 
 * @描述：AdminServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class AdminServiceImpl implements AdminService
{
    @Resource
    private AdminDao adminDao;


    @Override
    public Admin adminLogin(String adminname, String password) throws AdminServiceException
    {
        Admin admin = null;
        try
        {
            admin = this.adminDao.getAdminByAdminName(adminname);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        if (admin == null)
        {
            throw new AdminServiceException("抱歉，该账号不存在!");
        }
        if (!password.equals(admin.getPassword()))
        {
            throw new AdminServiceException("抱歉，该密码不正确!");
        }
        admin.setLaterdate(new Date());
        /*
         * try { this.adminDao.updateAdmin(admin); } catch (DataAccessException e) { e.printStackTrace(); }
         */
        return admin;
    }


    @Override
    public void insertAdmin(Admin admin) throws AdminServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteAdminById(Long id) throws AdminServiceException
    {
        try
        {
            this.adminDao.deleteAdminById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void updateAdmin(Admin admin) throws AdminServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Admin getAdminById(Long id) throws AdminServiceException
    {
        Admin admin = null;
        try
        {
            admin = this.adminDao.getAdminById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return admin;
    }


    @Override
    public List<Admin> getAllAdmin() throws AdminServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Admin> getAdminByParams(Map<String, Object> params) throws AdminServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Map<String, Object> getAdminList(Integer pageNumber, Integer pageSize, String adminname, String name) throws AdminServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(adminname))
        {
            params.put("adminname", adminname);
        }
        if (StringUtils.isNotEmpty(name))
        {
            params.put("name", name);
        }
        List<Admin> list = null;
        try
        {
            list = this.adminDao.getAdminByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = list.size() < fromRecord + pageSize ? list.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list == null ? null : list.subList(fromRecord, endRecord));
        map.put("total", list == null ? 0 : list.size());
        return map;
    }


    @Override
    public void saveAdminInfo(Long id, String adminname, String password, String sex, String phone, String email, Integer level, Integer status, String name) throws AdminServiceException
    {
        Admin admin = null;
        try
        {
            admin = (id == null ? new Admin() : this.adminDao.getAdminById(id));
            admin.setAdminname(adminname);
            admin.setPassword(password);
            admin.setSex(sex);
            admin.setPhone(phone);
            admin.setEmail(email);
            admin.setLevel(level);
            admin.setRegisterdate(new Date());
            admin.setLaterdate(new Date());
            admin.setStatus(status);
            admin.setName(name);

            if (id == null)
            {

                if (this.adminDao.getAdminByAdminName(adminname) != null)
                {
                    throw new AdminServiceException("该账号已经存在！");
                }

                this.adminDao.insertAdmin(admin);
            }
            else
            {
                this.adminDao.updateAdmin(admin);
            }
        }
        catch (DataAccessException e1)
        {
            e1.printStackTrace();
        }
    }

}
