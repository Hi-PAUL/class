package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Message;
import com.hisun.common.bean.User;
import com.hisun.common.exception.MessageServiceException;

/**
 * 
 * @类名： MessageService.java
 * 
 * @描述：MessageService @作者： PAUL @修改日期： 2016年3月22日
 *
 */

@Service
public interface MessageService
{

    void saveMessage(User uer, String title, String content) throws MessageServiceException;


    void insertMessage(Message message) throws MessageServiceException;


    void deleteMessageById(Long id) throws MessageServiceException;


    void updateMessage(Message message) throws MessageServiceException;


    Message getMessageById(Long id) throws MessageServiceException;


    List<Message> getMessageByClassId(Long classId) throws MessageServiceException;


    List<Message> getAllMessage() throws MessageServiceException;


    List<Message> getMessageByParams(Map<String, Object> params) throws MessageServiceException;


    Map<String, Object> getMessageList(Integer pageNumber, Integer pageSize, String username, String title) throws MessageServiceException;


    void saveMessageInfo(Long id, String username, String sex, String title, String content) throws MessageServiceException;
}
