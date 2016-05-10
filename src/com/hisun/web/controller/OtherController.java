package com.hisun.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtherController
{
    
    @RequestMapping(value = "help.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoHelp( HttpServletRequest request)
    {
        System.out.println("URL1 : "+request.getRequestURI());
        System.out.println("URL2 : "+request.getRemoteAddr());
        System.out.println("URL3 : "+request.getHeader("REFERER"));
        ModelAndView model = new ModelAndView("common/help");
        return model;
    }
    
    

    @RequestMapping(value = "join.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoJion()
    {
        ModelAndView model = new ModelAndView("common/join_we");
        return model;
    }

}



