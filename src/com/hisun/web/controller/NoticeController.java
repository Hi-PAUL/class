package com.hisun.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private NoticeService NoticeService;

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
            list = NoticeService.getNoticeByClassId(user.getClassid());
        }
        catch (NoticeServiceException e)
        {
            e.printStackTrace();
        }

        return new ResultObject(list);
    }

}
