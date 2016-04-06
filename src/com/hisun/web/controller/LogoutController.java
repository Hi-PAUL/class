package com.hisun.web.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.User;
import com.hisun.common.util.ResultObject;

/**
 * 
 * @类名： LogoutController.java
 * 
 * @描述：LogoutController @作者： PAUL @修改日期： 2016年3月29日
 *
 */
@Controller
public class LogoutController
{

    @RequestMapping(value = "logout.xhtml", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        User user = (User) request.getSession().getAttribute("user");
        // 删除会话
        request.getSession().removeAttribute("user");
        // 如果用户选择自动登录
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0)
        {
            for (Cookie c : cookies)
            {
                if (c.getName().equals("username"))
                {
                    c.setMaxAge(0);
                }
            }
        }
        // 定义新的cookie
        String name = URLEncoder.encode("username", "UTF-8");
        Cookie namecookie = new Cookie(name, user.getUsername());
        // 定义cookie生命周期
        namecookie.setMaxAge(0);
        // 把cookie加入到浏览器
        response.addCookie(namecookie);

        System.out.println("logout");
        ModelAndView model = new ModelAndView("index");
        return model;
    }


    @RequestMapping(value = "admin_logout.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject adminLogout(HttpServletRequest request)
    {

        // Admin admin = (Admin) request.getSession().getAttribute("admin");
        request.getSession().removeAttribute("admin");
        return new ResultObject();
    }

}
