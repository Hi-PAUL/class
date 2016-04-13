package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Notice;
import com.hisun.common.exception.NoticeServiceException;

/**
 * 
 * @类名： NoticeService.java
 * 
 * @描述：NoticeService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface NoticeService
{
    void insertNotice(Notice notice) throws NoticeServiceException;


    void deleteNoticeById(Long id) throws NoticeServiceException;


    void updateNotice(Notice notice) throws NoticeServiceException;


    Notice getNoticeById(Long id) throws NoticeServiceException;


    List<Notice> getNoticeByClassId(Long classId) throws NoticeServiceException;


    List<Notice> getAllNotice() throws NoticeServiceException;


    List<Notice> getNoticeByParams(Map<String, Object> params) throws NoticeServiceException;


    Map<String, Object> getNoticeList(Integer pageNumber, Integer pageSize, String publisher, String title) throws NoticeServiceException;


    void saveNoticeInfo(Long id, String publisher, String sex, String title, String content) throws NoticeServiceException;
}
