package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
        try
        {
            this.classDao.deleteClassById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

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


    @Override
    public Map<String, Object> getClassList(Integer pageNumber, Integer pageSize, String college, String major, String classname) throws ClassServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(college))
        {
            params.put("college", college);
        }
        if (StringUtils.isNotEmpty(major))
        {
            params.put("major", major);
        }
        if (StringUtils.isNotEmpty(classname))
        {
            params.put("classname", classname);
        }
        List<Class> classList = null;
        try
        {
            classList = this.classDao.getClassByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = classList.size() < fromRecord + pageSize ? classList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", classList == null ? null : classList.subList(fromRecord, endRecord));
        map.put("total", classList == null ? 0 : classList.size());
        return map;
    }


    @Override
    public void saveClassInfo(Long id, String college, String major, String classname, String classadviser, Integer number, String slogan, String introduce, String honour, String feature)
        throws ClassServiceException
    {
        Class c = null;
        try
        {
            c = (id == null ? new Class() : this.classDao.getClassById(id));
            c.setCollege(college);
            c.setMajor(major);
            c.setClassname(classname);
            c.setClassadviser(classadviser);
            c.setNumber(number);
            c.setSlogan(slogan);
            c.setIntroduce(introduce);
            c.setHonour(honour);
            c.setFeature(feature);
            if (id == null)
            {
                c.setCreatedate(new Date());
                this.classDao.insertClass(c);
            }
            else
            {
                this.classDao.updateClass(c);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

}
