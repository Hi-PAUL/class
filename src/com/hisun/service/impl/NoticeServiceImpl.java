package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Notice;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.NoticeServiceException;
import com.hisun.dao.NoticeDao;
import com.hisun.service.NoticeService;

/**
 * 
 * @类名： NoticeServiceImpl.java
 * 
 * @描述：NoticeServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class NoticeServiceImpl implements NoticeService
{
    @Resource
    private NoticeDao noticeDao;


    @Override
    public void insertNotice(Notice notice) throws NoticeServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteNoticeById(Long id) throws NoticeServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateNotice(Notice notice) throws NoticeServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Notice getNoticeById(Long id) throws NoticeServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Notice> getNoticeByClassId(Long classId) throws NoticeServiceException
    {
        List<Notice> list = null;
        try
        {
            list = noticeDao.getNoticeByClassId(classId);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Notice> getAllNotice() throws NoticeServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Notice> getNoticeByParams(Map<String, Object> params) throws NoticeServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
