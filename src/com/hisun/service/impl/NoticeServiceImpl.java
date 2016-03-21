package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Notice;
import com.hisun.service.NoticeService;

/**
 * 
 * @类名： NoticeServiceImpl.java
 * @描述：NoticeServiceImpl
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Repository
public class NoticeServiceImpl implements NoticeService
{

    @Override
    public void insertNotice(Notice notice)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteNoticeById(Long id)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateNotice(Notice notice)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Notice getNoticeById(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Notice> getAllNotice()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Notice> getNoticeByParams(Map<String, Object> params)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
