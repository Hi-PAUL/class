package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Notice;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： NoticeDao.java
 * 
 * @描述：NoticeDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface NoticeDao
{
    void insertNotice(Notice Notice) throws DataAccessException;


    void deleteNoticeById(Long id) throws DataAccessException;


    void updateNotice(Notice Notice) throws DataAccessException;


    Notice getNoticeById(Long id) throws DataAccessException;


    List<Notice> getNoticeByClassId(Long classId) throws DataAccessException;


    List<Notice> getAllNotice() throws DataAccessException;


    List<Notice> getNoticeByParams(Map<String, Object> params) throws DataAccessException;
}
