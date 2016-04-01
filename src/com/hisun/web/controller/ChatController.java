package com.hisun.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.TalkBean;
import com.hisun.common.bean.User;
import com.hisun.common.exception.UserServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.UserService;

/**
 * 
 * @类名： ChatController.java
 * 
 * @描述：ChatController @作者： PAUL @修改日期： 2016年3月30日
 *
 */
@Controller
public class ChatController extends HttpServlet
{

    private static final long serialVersionUID = 7941030153703195637L;

    @Resource
    private UserService userService;


    @RequestMapping(value = "chat_room.xhtml", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        System.out.println("chat_room");
        ModelAndView model = new ModelAndView("chat_room");
        return model;
    }


    @RequestMapping(value = "get_userOnlion_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getUserOnlionList(HttpServletRequest request)
    {

        User user = (User) request.getSession().getAttribute("user");
        int isonline = 1;
        Long classid = user.getClassid();
        List<User> list = null;
        try
        {
            list = userService.getUserByParams(isonline, classid);
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(list);
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "send_message.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject sendServlet(HttpServletRequest request, @RequestParam(value = "say") String say)
    {
        System.out.println(say);
        ServletContext application = request.getSession().getServletContext();
        User user = (User) request.getSession().getAttribute("user");
        String room = Long.toString(user.getClassid());
        List<TalkBean> talks = null;
        try
        {
            talks = (List<TalkBean>) application.getAttribute(room);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (talks == null)
        {
            talks = new ArrayList<TalkBean>();
            application.setAttribute(room, talks);
        }
        TalkBean tb = new TalkBean();
        tb.setSaid(say);
        tb.setUsername(user.getUsername());
        tb.setSendTime(System.currentTimeMillis());
        talks.add(tb);
        return new ResultObject();
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "refresh_chat.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getChatMessages(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        ServletContext application = request.getSession().getServletContext();
        String room = Long.toString(user.getClassid());
        List<TalkBean> talks = (List<TalkBean>) application.getAttribute(room);
        List<TalkBean> tempTalk = null;
        if (talks != null)
        {
            tempTalk = new ArrayList<TalkBean>();
            for (TalkBean tb : talks)
            {
                if (tb.getSendTime() >= user.getLaterdate().getTime())
                {
                    tempTalk.add(tb);
                }
            }
            return new ResultObject(tempTalk);
        }
        else
        {
            return new ResultObject();
        }
    }

}
