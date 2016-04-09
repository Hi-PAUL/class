package com.hisun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Result;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.ResultServiceException;
import com.hisun.dao.ResultDao;
import com.hisun.service.ResultService;

/**
 * 
 * @类名： ResultServiceImpl.java
 * 
 * @描述：ResultServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class ResultServiceImpl implements ResultService
{
    @Resource
    private ResultDao resultDao;


    @Override
    public void insertResult(Result result) throws ResultServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteResultById(Long id) throws ResultServiceException
    {
        try
        {
            this.resultDao.deleteResultById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void updateResult(Result result) throws ResultServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Result getResultById(Long id) throws ResultServiceException
    {
        Result result = null;
        try
        {
            result = this.resultDao.getResultById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Result> getAllResult() throws ResultServiceException
    {

        return null;
    }


    @Override
    public List<Result> getResultByParams(String studentId, String session) throws ResultServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(studentId))
        {
            params.put("studentid", studentId);
        }
        if (StringUtils.isNotEmpty(session))
        {
            params.put("session", session);
        }
        List<Result> resultList = null;
        try
        {
            resultList = this.resultDao.getResultByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return resultList;
    }


    public Map<String, Object> getResultList(Integer pageNumber, Integer pageSize, String studentId, String banbie, String session, String coursename) throws ResultServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(studentId))
        {
            params.put("studentid", studentId);
        }
        if (StringUtils.isNotEmpty(banbie))
        {
            params.put("banbie", banbie);
        }
        if (StringUtils.isNotEmpty(session))
        {
            params.put("session", session);
        }
        if (StringUtils.isNotEmpty(coursename))
        {
            params.put("coursename", coursename);
        }
        List<Result> resultList = null;
        try
        {
            resultList = this.resultDao.getResultByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = resultList.size() < fromRecord + pageSize ? resultList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", resultList == null ? null : resultList.subList(fromRecord, endRecord));
        map.put("total", resultList == null ? 0 : resultList.size());
        return map;
    }


    @Override
    public void saveResultInfo(Long id, String studentid, String banbie, String name, String session, String coursename, String coursecode, Integer period, Integer credit, Double scores,
        String remark) throws ResultServiceException
    {
        Result result = null;
        try
        {
            result = (id == null ? new Result() : this.resultDao.getResultById(id));
            result.setStudentid(studentid);
            result.setBanbie(banbie);
            result.setName(name);
            result.setSession(session);
            result.setCoursename(coursename);
            result.setCoursecode(coursecode);
            result.setPeriod(period);
            result.setCredit(credit);
            result.setScores(scores);
            result.setRemark(remark);
            if (id == null)
            {
                this.resultDao.insertResult(result);
            }
            else
            {
                this.resultDao.updateResult(result);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }

}
