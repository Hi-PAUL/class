package com.hisun.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hisun.common.bean.User;
import com.hisun.dao.UserDao;

public class SessionListener implements HttpSessionListener
{
    private UserDao userDao;


    @Override
    public void sessionCreated(HttpSessionEvent event)
    {
        System.out.println("用户访问网页!");
        @SuppressWarnings("resource")
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        userDao = (UserDao) ac.getBean("userDao");
    }


    @Override
    public void sessionDestroyed(HttpSessionEvent event)
    {
        // ServletContext application = event.getSession().getServletContext();
        User user = (User) event.getSession().getAttribute("user");
        user.setIsonline(0);
        this.userDao.updateUser(user);
        System.out.println(user.getUsername() + "退出！");

    }

}
