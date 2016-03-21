package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Notice;

/**
 * 
 * @类名： NoticeDao.java
 * @描述：NoticeDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface NoticeDao
{
    void insertNotice(Notice Notice);


    void deleteNoticeById(Long id);


    void updateNotice(Notice Notice);


    Notice getNoticeById(Long id);


    List<Notice> getAllNotice();


    List<Notice> getNoticeByParams(Map<String, Object> params);
}
