package com.hisun.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hisun.common.bean.User;

public class SessionListener implements HttpSessionListener
{
    
    

    public void sessionCreated(HttpSessionEvent event)
    {
        System.out.println("用户登陆！");
    }


    public void sessionDestroyed(HttpSessionEvent event)
    {

        // ServletContext application = event.getSession().getServletContext();

        User user = (User) event.getSession().getAttribute("user");

        System.out.println(user.getUsername() + "退出！");

    }

}
