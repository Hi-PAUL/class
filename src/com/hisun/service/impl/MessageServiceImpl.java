package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
        try
        {
            this.messageDao.deleteMessageById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updateMessage(Message message) throws MessageServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Message getMessageById(Long id) throws MessageServiceException
    {
        Message message = null;
        try
        {
            message = this.messageDao.getMessageById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return message;
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


    @Override
    public Map<String, Object> getMessageList(Integer pageNumber, Integer pageSize, String username, String title) throws MessageServiceException
    {

        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(username))
        {
            params.put("username", username);
        }
        if (StringUtils.isNotEmpty(title))
        {
            params.put("title", title);
        }

        List<Message> messageList = null;
        try
        {
            messageList = this.messageDao.getMessageByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = messageList.size() < fromRecord + pageSize ? messageList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", messageList == null ? null : messageList.subList(fromRecord, endRecord));
        map.put("total", messageList == null ? 0 : messageList.size());
        return map;
    }


    @Override
    public void saveMessageInfo(Long id, String username, String sex, String title, String content) throws MessageServiceException
    {
        Message message = null;
        try
        {
            message = (id == null ? new Message() : this.messageDao.getMessageById(id));
            message.setUsername(username);
            message.setSex(sex);
            message.setTitle(title);
            message.setFaceurl(username);
            message.setTitle(title);
            message.setContent(content);
            message.setClassid(1L);
            if (id == null)
            {
                message.setDateline(new Date());
                this.messageDao.insertMessage(message);
            }
            else
            {
                this.messageDao.updateMessage(message);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }

    }

}
