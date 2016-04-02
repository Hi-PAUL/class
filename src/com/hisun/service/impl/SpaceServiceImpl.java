package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Space;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.SpaceServiceException;
import com.hisun.dao.SpaceDao;
import com.hisun.service.SpaceService;

/**
 * 
 * @类名： SpaceServiceImpl.java
 * 
 * @描述：SpaceServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class SpaceServiceImpl implements SpaceService
{
    @Resource
    private SpaceDao spaceDao;


    @Override
    public void insertSpace(Space space) throws SpaceServiceException
    {
        try
        {
            this.spaceDao.insertSpace(space);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteSpaceById(Long id) throws SpaceServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateSpace(Space space) throws SpaceServiceException
    {
        try
        {
            this.spaceDao.updateSpace(space);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public Space getSpaceById(Long id) throws SpaceServiceException
    {
        Space space = null;
        try
        {
            space = this.spaceDao.getSpaceById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return space;
    }


    @Override
    public Space getSpaceByUserId(Long userId) throws SpaceServiceException
    {
        Space space = null;
        try
        {
            space = this.spaceDao.getSpaceByUserId(userId);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return space;
    }


    @Override
    public List<Space> getAllSpace() throws SpaceServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Space> getSpaceByParams(Map<String, Object> params) throws SpaceServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
