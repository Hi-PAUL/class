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

import com.hisun.common.bean.Admin;
import com.hisun.common.exception.AdminServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.AdminService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： ClassController.java
 * 
 * @描述：ClassController @作者： PAUL @修改日期： 2016年4月5日
 *
 */
@Controller
public class AdminController
{
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "admin_home.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoAdminHome(HttpServletRequest request)
    {

        System.out.println("my_class");
        ModelAndView model = new ModelAndView("admin/home");
        return model;
    }


    @RequestMapping(value = "admin_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoAdminList(HttpServletRequest request)
    {

        System.out.println("admin_list");
        ModelAndView model = new ModelAndView("admin/admin_list");
        return model;
    }


    @RequestMapping(value = "get_admin_list", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getAdminList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "adminname", required = false) String adminname,
        @RequestParam(value = "name", required = false) String name)
    {
        Map<String, Object> list = null;

        try
        {
            list = this.adminService.getAdminList(pageNumber, pageSize, adminname, name);
        }
        catch (AdminServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "admin_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoApplicationEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        // String projectId = (String) request.getSession().getAttribute("projectId");
        // List<BusinessGroup> groupList = businessGroupService.getBusinessGroupByProjectId(projectId);
        return new ModelAndView("admin/admin_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_admin_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getAdminById(@RequestParam(value = "id") Long id)
    {
        Admin admin = null;
        try
        {
            admin = this.adminService.getAdminById(id);
        }
        catch (AdminServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println("json :"+admin);
        return new ResultObject(admin);
    }


    @RequestMapping(value = "save_admin_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveAdminInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "adminname", required = false) String adminname,
        @RequestParam(value = "password", required = false) String password, @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "email", required = false) String email, @RequestParam(value = "level", required = false) Integer level, @RequestParam(value = "status", required = false) Integer status,
        @RequestParam(value = "name", required = false) String name)
    {
        try
        {
            this.adminService.saveAdminInfo(id, adminname, password, sex, phone, email, level, status, name);
            return new ResultObject();
        }
        catch (Exception e)
        {
            return new ResultObject(110, e.getMessage());
        }

    }


    @RequestMapping(value = "delete_admin_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deleteAdminById(@RequestParam(value = "id") Long id)
    {
        System.out.println(id);
        try
        {
            this.adminService.deleteAdminById(id);
        }
        catch (AdminServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
