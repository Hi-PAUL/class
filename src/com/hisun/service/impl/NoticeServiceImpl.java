package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
        try
        {
            this.noticeDao.deleteNoticeById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updateNotice(Notice notice) throws NoticeServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Notice getNoticeById(Long id) throws NoticeServiceException
    {
        Notice notice = null;
        try
        {
            notice = this.noticeDao.getNoticeById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return notice;
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


    @Override
    public Map<String, Object> getNoticeList(Integer pageNumber, Integer pageSize, String publisher, String title) throws NoticeServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(publisher))
        {
            params.put("publisher", publisher);
        }
        if (StringUtils.isNotEmpty(title))
        {
            params.put("title", title);
        }

        List<Notice> noticeList = null;
        try
        {
            noticeList = this.noticeDao.getNoticeByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = noticeList.size() < fromRecord + pageSize ? noticeList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", noticeList == null ? null : noticeList.subList(fromRecord, endRecord));
        map.put("total", noticeList == null ? 0 : noticeList.size());
        return map;
    }


    @Override
    public void saveNoticeInfo(Long id, String publisher, String sex, String title, String content) throws NoticeServiceException
    {
        Notice notice = null;
        try
        {
            notice = (id == null ? new Notice() : this.noticeDao.getNoticeById(id));
            notice.setPublisher(publisher);
            notice.setSex(sex);
            notice.setTitle(title);
            notice.setContent(content);
            if (id == null)
            {
                notice.setClassid(1L);
                notice.setDateline(new Date());
                this.noticeDao.insertNotice(notice);
            }
            else
            {
                this.noticeDao.updateNotice(notice);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

}
