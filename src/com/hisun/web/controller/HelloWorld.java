package com.hisun.web.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.User;
import com.hisun.common.util.ResultObject;
import com.hisun.service.UserService;

/**
 * 
 * @author PAUL
 *
 */
@Controller
public class HelloWorld
{
    @Resource
    private UserService userService;
 
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public ModelAndView hello(@RequestParam(value = "id", required = false) Long id)
    {
        System.out.println("hello world");
        User user=userService.selectByPrimaryKey(id);
        System.out.println(user);
        //成功后跳转到success.jsp页面，并带user数据
        ModelAndView model = new ModelAndView("success").addObject("user", user);
        return model;
    }

    @RequestMapping(value = "global", method = RequestMethod.GET)
    public ModelAndView global()
    {
        System.out.println("hello world");
        
        ModelAndView model = new ModelAndView("../globaltest");
        return model;
    }
    
    
    //异步请求，返回json格式数据
    @RequestMapping(value = "get_application_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getapplicationById(@RequestParam(value = "id") Long id)
    {
       
        return new ResultObject();
    }
    
}
