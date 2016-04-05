package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Class;
import com.hisun.common.exception.ClassServiceException;
import com.hisun.common.exception.DataAccessException;
import com.hisun.dao.ClassDao;
import com.hisun.service.ClassService;

/**
 * 
 * @类名： ClassServiceImpl.java
 * 
 * @描述：ClassServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class ClassServiceImpl implements ClassService
{
    @Resource
    private ClassDao classDao;


    @Override
    public void insertClass(Class clas) throws ClassServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteClassById(Long id) throws ClassServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateClass(Class clas) throws ClassServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Class getClassById(Long id) throws ClassServiceException
    {
        Class c = null;
        try
        {
            c = classDao.getClassById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return c;
    }


    @Override
    public List<Class> getAllClass() throws ClassServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Class> getClassByParams(Map<String, Object> params) throws ClassServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
