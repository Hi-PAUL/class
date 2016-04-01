package com.hisun.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Message;
import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.MessageServiceException;
import com.hisun.dao.MessageDao;
import com.hisun.service.MessageService;

/**
 * 
 * @类名： MessageServiceImpl.java
 * 
 * @描述：MessageServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class MessageServiceImpl implements MessageService
{
    @Resource
    private MessageDao messageDao;


    @Override
    public void saveMessage(User user, String title, String content) throws MessageServiceException
    {
        Message message = new Message();
        message.setUsername(user.getUsername());
        message.setTitle(title);
        message.setContent(content);
        message.setUrl(user.getUsername());
        message.setFaceurl(user.getUsername());
        message.setClassid(user.getClassid());
        message.setSex(user.getSex());
        message.setDateline(new Date());
        try
        {
            messageDao.insertMessage(message);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            throw new MessageServiceException(e.getMessage());
        }
    }


    @Override
    public void insertMessage(Message message) throws MessageServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteMessageById(Long id) throws MessageServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateMessage(Message message) throws MessageServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Message getMessageById(Long id) throws MessageServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Message> getMessageByClassId(Long classId) throws MessageServiceException
    {
        List<Message> list = null;

        try
        {
            list = messageDao.getMessageByClassId(classId);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            throw new MessageServiceException(e.getMessage());
        }

        return list;
    }


    @Override
    public List<Message> getAllMessage() throws MessageServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Message> getMessageByParams(Map<String, Object> params) throws MessageServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
