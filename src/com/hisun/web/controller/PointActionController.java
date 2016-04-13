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

import com.hisun.common.bean.PointAction;
import com.hisun.common.exception.PointActionServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.PointActionService;

/**
 * 
 * @类名： PointActionController.java
 * @描述：PointActionController
 * @作者： PAUL
 * @修改日期： 2016年4月13日
 *
 */
@Controller
public class PointActionController
{
    @Resource
    private PointActionService pointActionService;

    @RequestMapping(value = "pointaction_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPointActioneList()
    {
        System.out.println("pointaction_list.xhtml");
        ModelAndView model = new ModelAndView("admin/pointaction_list");
        return model;
    }


    @RequestMapping(value = "get_pointaction_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getPointActionList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, 
        @RequestParam(value = "actionname", required = false) String actionname)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.pointActionService.getPointActionList(pageNumber, pageSize,actionname);
        }
        catch (PointActionServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "pointaction_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPointActionEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/pointaction_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_pointaction_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getPointActionById(@RequestParam(value = "id") Long id)
    {
        PointAction pointaction = null;
        try
        {
            pointaction = this.pointActionService.getPointActionById(id);
        }
        catch (PointActionServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(pointaction);
    }


    @RequestMapping(value = "save_pointaction_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject savePointActionInfo(@RequestParam(value = "id", required = false) Long id, 
        @RequestParam(value = "actionname", required = false) String actionname,
        @RequestParam(value = "point", required = false) Integer point, 
        @RequestParam(value = "description", required = false) String description)
    {
        try
        {
            this.pointActionService.savePointActionInfo(id, actionname, point, description);
        }
        catch (PointActionServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_pointaction_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deletePointActionById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.pointActionService.deletePointActionById(id);
        }
        catch (PointActionServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
