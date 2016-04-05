package com.hisun.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.User;
import com.hisun.common.exception.UserServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.UserService;

/**
 * 
 * @类名： UserController.java
 * 
 * @描述：UserController @作者： PAUL @修改日期： 2016年3月28日
 *
 */
@Controller
public class UserController
{
    @Resource
    private UserService userService;


    @RequestMapping(value = "activity.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoActivity()
    {
        System.out.println("activity");
        ModelAndView model = new ModelAndView("activity");
        return model;
    }


    @RequestMapping(value = "register.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoRegister()
    {
        System.out.println("register");
        ModelAndView model = new ModelAndView("register");
        return model;
    }
    
    @RequestMapping(value = "address_book.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoAddressBook()
    {
        System.out.println("address_book");
        ModelAndView model = new ModelAndView("address_book");
        return model;
    }
    


    @RequestMapping(value = "save_user_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveUserInfo(HttpServletRequest request, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "password", required = false) String password, @RequestParam(value = "email", required = false) String email,
        @RequestParam(value = "authCode", required = false) String authCode)
    {
        String code = (String) request.getSession().getAttribute("authCode");
        System.out.println(code);
        System.err.println(authCode);
        if (!authCode.equals(code))
        {
            return new ResultObject(110, "验证码不准确!");
        }

        try
        {
            userService.register(username, password, email);
        }
        catch (UserServiceException e)
        {
            return new ResultObject(110, e.getMessage());
        }

        return new ResultObject();
    }


    @RequestMapping(value = "activate.xhtml", method = RequestMethod.GET)
    public ModelAndView activate(HttpServletRequest request, @RequestParam(value = "name", required = false) String username, @RequestParam(value = "cdKey", required = false) String cdKey)
    {
        User user = null;
        try
        {
            user = userService.activate(username, cdKey);
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        request.getSession().setAttribute("user", user);
        ModelAndView model = new ModelAndView("activity");
        return model;

    }
    
    
    @RequestMapping(value = "get_address_book_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject userLogin(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize)
    {
        User user = (User) request.getSession().getAttribute("user");
        Map<String, Object> list = null;
        try
        {
            list = this.userService.getUserList(pageNumber, pageSize, user.getClassid());
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }
    
    
    

}
