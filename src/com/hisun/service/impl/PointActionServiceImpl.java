package com.hisun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hisun.common.bean.PointAction;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.PointActionServiceException;
import com.hisun.dao.PointActionDao;
import com.hisun.service.PointActionService;

/**
 * 
 * @类名： PointActionServiceImpl.java
 * 
 * @描述：PointActionServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class PointActionServiceImpl implements PointActionService
{
    @Resource
    private PointActionDao pointActionDao;


    @Override
    public void insertPointAction(PointAction pointAction) throws PointActionServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deletePointActionById(Long id) throws PointActionServiceException
    {
        try
        {
            this.pointActionDao.deletePointActionById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updatePointAction(PointAction pointAction) throws PointActionServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public PointAction getPointActionById(Long id) throws PointActionServiceException
    {
        PointAction pointaction = null;
        try
        {
            pointaction = this.pointActionDao.getPointActionById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return pointaction;
    }


    @Override
    public List<PointAction> getAllPointAction() throws PointActionServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<PointAction> getPointActionByParams(Map<String, Object> params) throws PointActionServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Map<String, Object> getPointActionList(Integer pageNumber, Integer pageSize, String actionname) throws PointActionServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(actionname))
        {
            params.put("actionname", actionname);
        }
        List<PointAction> pointActionList = null;
        try
        {
            pointActionList = this.pointActionDao.getPointActionByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = pointActionList.size() < fromRecord + pageSize ? pointActionList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", pointActionList == null ? null : pointActionList.subList(fromRecord, endRecord));
        map.put("total", pointActionList == null ? 0 : pointActionList.size());
        return map;
    }


    @Override
    public void savePointActionInfo(Long id, String actionname, Integer point, String description) throws PointActionServiceException
    {
        PointAction pointAction = null;
        try
        {
            pointAction = (id == null ? new PointAction() : this.pointActionDao.getPointActionById(id));
            pointAction.setActionname(actionname);
            pointAction.setPoint(point);
            pointAction.setDescription(description);
            if (id == null)
            {
                this.pointActionDao.insertPointAction(pointAction);
            }
            else
            {
                this.pointActionDao.updatePointAction(pointAction);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

}
