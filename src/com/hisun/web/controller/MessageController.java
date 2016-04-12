package com.hisun.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping(value = "message_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoResultList()
    {
        System.out.println("messgae_list.xhtml");
        ModelAndView model = new ModelAndView("admin/message_list");
        return model;
    }


    @RequestMapping(value = "find_message_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject findMessageList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "title", required = false) String title)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.messageService.getMessageList(pageNumber, pageSize, username, title);
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "message_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoMessageEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/message_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_message_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getResultById(@RequestParam(value = "id") Long id)
    {
        Message message = null;
        try
        {
            message = this.messageService.getMessageById(id);
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(message);
    }


    @RequestMapping(value = "save_message_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveMessageInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "content", required = false) String content)
    {
        try
        {
            this.messageService.saveMessageInfo(id, username, sex, title, content);
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_message_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteMessageById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.messageService.deleteMessageById(id);
        }
        catch (MessageServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
