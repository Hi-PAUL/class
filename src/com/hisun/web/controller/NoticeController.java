package com.hisun.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Notice;
import com.hisun.common.bean.User;
import com.hisun.common.exception.NoticeServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.NoticeService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： NoticeController.java
 * 
 * @描述：NoticeController @作者： PAUL @修改日期： 2016年3月31日
 *
 */
@Controller
public class NoticeController
{
    @Resource
    private NoticeService noticeService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "get_notice_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getNoticeList(HttpServletRequest request)
    {

        User user = (User) request.getSession().getAttribute("user");
        List<Notice> list = null;
        try
        {
            list = noticeService.getNoticeByClassId(user.getClassid());
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
        }

        return new ResultObject(list);
    }


    @RequestMapping(value = "notice_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoNoticeList()
    {
        System.out.println("notice_list.xhtml");
        ModelAndView model = new ModelAndView("admin/notice_list");
        return model;
    }


    @RequestMapping(value = "find_notice_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject findnoticeList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "publisher", required = false) String publisher,
        @RequestParam(value = "title", required = false) String title)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.noticeService.getNoticeList(pageNumber, pageSize, publisher, title);
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "notice_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoNoticeEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/notice_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_notice_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getNoticeById(@RequestParam(value = "id") Long id)
    {
        Notice notice = null;
        try
        {
            notice = this.noticeService.getNoticeById(id);
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(notice);
    }


    @RequestMapping(value = "save_notice_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveNoticeInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "publisher", required = false) String publisher,
        @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "content", required = false) String content)
    {
        System.out.println("lll " + publisher);
        try
        {
            this.noticeService.saveNoticeInfo(id, publisher, sex, title, content);
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_notice_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteNoticeById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.noticeService.deleteNoticeById(id);
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
