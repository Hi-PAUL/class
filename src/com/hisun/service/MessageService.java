package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Message;

/**
 * 
 * @类名： MessageService.java
 * @描述：MessageService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface MessageService
{
    void insertMessage(Message message);


    void deleteMessageById(Long id);


    void updateMessage(Message message);


    Message getMessageById(Long id);


    List<Message> getAllMessage();


    List<Message> getMessageByParams(Map<String, Object> params);
}
