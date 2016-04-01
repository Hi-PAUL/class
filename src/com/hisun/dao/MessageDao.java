package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Message;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： MessageDao.java
 * 
 * @描述：MessageDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface MessageDao
{
    void insertMessage(Message Message) throws DataAccessException;


    void deleteMessageById(Long id) throws DataAccessException;


    void updateMessage(Message Message) throws DataAccessException;


    Message getMessageById(Long id) throws DataAccessException;


    List<Message> getMessageByClassId(Long classId) throws DataAccessException;


    List<Message> getAllMessage() throws DataAccessException;


    List<Message> getMessageByParams(Map<String, Object> params) throws DataAccessException;
}
