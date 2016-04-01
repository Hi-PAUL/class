package com.hisun.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class ChatController
{

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

}
