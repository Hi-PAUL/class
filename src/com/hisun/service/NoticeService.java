package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Notice;

/**
 * 
 * @类名： NoticeService.java
 * @描述：NoticeService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface NoticeService
{
    void insertNotice(Notice notice);


    void deleteNoticeById(Long id);


    void updateNotice(Notice notice);


    Notice getNoticeById(Long id);


    List<Notice> getAllNotice();


    List<Notice> getNoticeByParams(Map<String, Object> params);
}
