package com.hisun.web.filter;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;
import com.hisun.dao.UserDao;

/**
 * 
 * @类名： AuothLoginFilter.java
 * @描述：AuothLoginFilter
 * @作者： PAUL
 * @修改日期： 2016年3月28日
 *
 */
public class AuothLoginFilter implements Filter
{

    private UserDao userDao;


    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
        @SuppressWarnings("resource")
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        userDao = (UserDao) ac.getBean("userDao");
    }


    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse resp = (HttpServletResponse) arg1;
        HttpSession session = req.getSession();

        String username = "";
        Cookie[] cookie = req.getCookies();
        if (cookie != null && cookie.length > 0)
        {
            for (Cookie c : cookie)
            {
                if (c.getName().equals("username"))
                {
                    username = URLDecoder.decode(c.getValue(), "UTF-8");
                }
            }
        }

        System.out.println("cookies : " + cookie);
        if (!"".equals(username))
        {

            System.out.println("cookieusername : " + username);

            User user = null;
            try
            {
                user = userDao.getUserByUsername(username);
            }
            catch (DataAccessException e)
            {
                e.printStackTrace();
            }
            System.out.println("auothLogin  : " + user);

            if (null != user)
            {
                session.setAttribute("user", user);
                req.getRequestDispatcher("activity.xhtml").forward(req, resp);
            }
        }
        arg2.doFilter(req, resp);
    }


    @Override
    public void destroy()
    {

    }
}
