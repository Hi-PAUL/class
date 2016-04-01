package com.hisun.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hisun.common.bean.Message;
import com.hisun.common.bean.User;
import com.hisun.common.exception.MessageServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.MessageService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： NoticeController.java
 * 
 * @描述：NoticeController @作者： PAUL @修改日期： 2016年3月31日
 *
 */
@Controller
public class MessageController
{
    @Resource
    private MessageService messageService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "get_message_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getMessageList(HttpServletRequest request)
    {

        User user = (User) request.getSession().getAttribute("user");
        List<Message> list = null;

        try
        {
            list = this.messageService.getMessageByClassId(user.getClassid());
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject(list);
    }


    @RequestMapping(value = "save_message.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveMessage(HttpServletRequest request, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "content", required = false) String content)
    {

        User user = (User) request.getSession().getAttribute("user");

        try
        {
            this.messageService.saveMessage(user, title, content);
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }

}
