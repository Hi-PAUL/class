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

import com.hisun.common.bean.Class;
import com.hisun.common.bean.User;
import com.hisun.common.exception.ClassServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.ClassService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： ClassController.java
 * 
 * @描述：ClassController @作者： PAUL @修改日期： 2016年4月5日
 *
 */
@Controller
public class ClassController
{
    @Resource
    private ClassService classService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "my_class.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoIndex(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        Class c = null;
        try
        {
            c = this.classService.getClassById(user.getClassid());
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println("my_class");
        ModelAndView model = new ModelAndView("my_class").addObject("classes", c);
        return model;
    }


    @RequestMapping(value = "class_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoResultList()
    {
        System.out.println("class_list.xhtml");
        ModelAndView model = new ModelAndView("admin/class_list");
        return model;
    }


    @RequestMapping(value = "get_class_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getResultList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "college", required = false) String college,
        @RequestParam(value = "major", required = false) String major, @RequestParam(value = "classname", required = false) String classname)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.classService.getClassList(pageNumber, pageSize, college, major, classname);
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "class_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoResultEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/class_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_class_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getResultById(@RequestParam(value = "id") Long id)
    {
        Class c = null;
        try
        {
            c = this.classService.getClassById(id);
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(c);
    }


    @RequestMapping(value = "save_class_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveClassInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "college", required = false) String college,
        @RequestParam(value = "major", required = false) String major, @RequestParam(value = "classname", required = false) String classname,
        @RequestParam(value = "classadviser", required = false) String classadviser, @RequestParam(value = "number", required = false) Integer number,
        @RequestParam(value = "slogan", required = false) String slogan, @RequestParam(value = "introduce", required = false) String introduce,
        @RequestParam(value = "honour", required = false) String honour, @RequestParam(value = "feature", required = false) String feature)
    {
        try
        {
            this.classService.saveClassInfo(id, college, major, classname, classadviser, number, slogan, introduce, honour, feature);
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_class_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteClassById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.classService.deleteClassById(id);
        }
        catch (ClassServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
