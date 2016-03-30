package com.hisun.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "chat_room.xhtml", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        System.out.println("chat_room");
        ModelAndView model = new ModelAndView("chat_room");
        return model;
    }

}
