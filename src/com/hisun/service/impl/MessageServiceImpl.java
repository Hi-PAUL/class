package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Message;
import com.hisun.service.MessageService;

/**
 * 
 * @类名： MessageServiceImpl.java
 * @描述：MessageServiceImpl
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Repository
public class MessageServiceImpl implements MessageService
{

    @Override
    public void insertMessage(Message message)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteMessageById(Long id)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateMessage(Message message)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Message getMessageById(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Message> getAllMessage()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Message> getMessageByParams(Map<String, Object> params)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
