package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Message;

/**
 * 
 * @类名： MessageDao.java
 * @描述：MessageDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface MessageDao
{
    void insertMessage(Message Message);


    void deleteMessageById(Long id);


    void updateMessage(Message Message);


    Message getMessageById(Long id);


    List<Message> getAllMessage();


    List<Message> getMessageByParams(Map<String, Object> params);
}
