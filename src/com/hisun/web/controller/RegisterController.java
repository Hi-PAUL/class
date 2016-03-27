package com.hisun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController
{
    @RequestMapping(value = "register.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoRegister()
    {
        System.out.println("register");
        ModelAndView model = new ModelAndView("register");
        return model;
    }

}
