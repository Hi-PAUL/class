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

import com.hisun.common.bean.News;
import com.hisun.common.exception.NewsServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.NewsService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： NewsController.java
 * 
 * @描述：NewsController @作者： PAUL @修改日期： 2016年5月11日
 *
 */
@Controller
public class NewsController
{
    @Resource
    private NewsService newsService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "news_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoNewsList()
    {
        System.out.println("newslist_list.xhtml");
        ModelAndView model = new ModelAndView("admin/news_list");
        return model;
    }


    @RequestMapping(value = "list_news.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoListNews()
    {
        ModelAndView model = new ModelAndView("common/list_news");
        return model;
    }


    @RequestMapping(value = "list_active.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoListActive()
    {
        ModelAndView model = new ModelAndView("common/list_active");
        return model;
    }


    @RequestMapping(value = "list_school.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoListSchool()
    {
        ModelAndView model = new ModelAndView("common/list_school");
        return model;
    }


    @RequestMapping(value = "info_news.xhtml", method = RequestMethod.GET)
    public ModelAndView getNews(@RequestParam(value = "id") Long id)
    {
        News news = null;
        try
        {
            news = this.newsService.getNewsById(id);
        }
        catch (NewsServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("common/info_news").addObject("news", news);
        return model;
    }


    @RequestMapping(value = "find_news_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject findNewsList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "publisher", required = false) String publisher,
        @RequestParam(value = "title", required = false) String title, @RequestParam(value = "node", required = false) String node)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.newsService.getNewsList(pageNumber, pageSize, publisher, title, node);
        }
        catch (NewsServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "news_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoMessageEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/news_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_news_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getNewsById(@RequestParam(value = "id") Long id)
    {
        News news = null;
        try
        {
            news = this.newsService.getNewsById(id);
        }
        catch (NewsServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(news);
    }


    @RequestMapping(value = "save_news_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveNewsInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "publisher", required = false) String publisher,
        @RequestParam(value = "node", required = false) String node, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "content", required = false) String content)
    {
        try
        {
            this.newsService.saveNewsInfo(id, publisher, node, title, content);
        }
        catch (NewsServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_news_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteNewsById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.newsService.deleteNewsById(id);
        }
        catch (NewsServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
