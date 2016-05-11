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


    @RequestMapping(value = "select_class.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoClassList()
    {
        ModelAndView model = new ModelAndView("select_class");
        return model;
    }


    @RequestMapping(value = "join_class.xhtml", method = RequestMethod.GET)
    public ModelAndView joinClass(HttpServletRequest request, @RequestParam(value = "classId", required = false) Long classId)
    {
        User user = (User) request.getSession().getAttribute("user");
        user.setClassid(classId);
        userService.updateUser(user);
        request.getSession().setAttribute("user", user);
        ModelAndView model = new ModelAndView("activity");
        return model;
    }


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
        String message;
        try
        {
            userService.activate(username, cdKey);
            ModelAndView model = new ModelAndView("login").addObject("username", username);
            return model;
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
            message = e.getMessage();
        }
        ModelAndView model = new ModelAndView("login").addObject("message", message);
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
            list = this.userService.getUserList(pageNumber, pageSize, null, null, user.getClassid());
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "user_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoUserList(HttpServletRequest request)
    {

        System.out.println("user_list");
        ModelAndView model = new ModelAndView("admin/user_list");
        return model;
    }


    @RequestMapping(value = "get_user_list", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getUserList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "name", required = false) String name)
    {
        Map<String, Object> list = null;

        try
        {
            list = this.userService.getUserList(pageNumber, pageSize, username, name, null);
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "user_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoApplicationEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/user_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_user_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getUserById(@RequestParam(value = "id") Long id)
    {
        User user = this.userService.getUserById(id);
        return new ResultObject(user);

    }


    @RequestMapping(value = "insert_user_info.json", method = RequestMethod.POST)

    @ResponseBody
    public ResultObject saveUserInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "qq", required = false) String qq, @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "email", required = false) String email, @RequestParam(value = "status", required = false) Integer status, @RequestParam(value = "point", required = false) Long point,
        @RequestParam(value = "name", required = false) String name, @RequestParam(value = "studentid", required = false) String studentid)
    {
        try
        {
            this.userService.saveUseInfo(id, username, sex, qq, phone, email, status, point, name, studentid);
            return new ResultObject();
        }
        catch (Exception e)
        {
            return new ResultObject(110, e.getMessage());
        }

    }


    @RequestMapping(value = "delete_user_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteUserById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.userService.deleteUserById(id);
        }
        catch (UserServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
