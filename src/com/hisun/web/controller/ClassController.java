package com.hisun.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.User;
import com.hisun.common.bean.Class;
import com.hisun.common.exception.ClassServiceException;
import com.hisun.service.ClassService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： ClassController.java
 * 
 * @描述：ClassController @作者： PAUL @修改日期： 2016年4月5日
 *
 */
@Controller
public class ClassController
{
    @Resource
    private ClassService classService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "my_class.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoIndex(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        Class c = null;
        try
        {
            c = this.classService.getClassById(user.getClassid());
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println("my_class");
        ModelAndView model = new ModelAndView("my_class").addObject("classes", c);
        return model;
    }

}
