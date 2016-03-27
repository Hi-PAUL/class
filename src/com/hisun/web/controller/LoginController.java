package com.hisun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
    @RequestMapping(value = "index.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoIndex()
    {
        System.out.println("index");
        ModelAndView model = new ModelAndView("index");
        return model;
    }


    @RequestMapping(value = "login.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoLogin()
    {
        System.out.println("login");
        ModelAndView model = new ModelAndView("login");
        return model;
    }
    
    
    
    

}
