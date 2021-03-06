package com.hisun.web.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 
 * @类名： GlobalController.java
 * 
 * @描述：GlobalController @作者： PAUL @修改日期： 2016年3月29日
 *
 */
@Controller
public class GlobalController
{
    @RequestMapping(value = "lang", method = RequestMethod.GET)
    public String language(HttpServletRequest request, Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType, @RequestParam(value = "path") String path)
    {
        if (!model.containsAttribute("contentModel"))
        {
            if (langType.equals("zh"))
            {
                Locale locale = new Locale("zh", "CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }
            else if (langType.equals("en"))
            {
                Locale locale = new Locale("en", "US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            }
            else
            {
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }
        }
        return path;
    }
}
