package com.hisun.web.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Space;
import com.hisun.common.bean.User;
import com.hisun.common.exception.SpaceServiceException;
import com.hisun.common.util.ImageUtil;
import com.hisun.common.util.ResultObject;
import com.hisun.service.SpaceService;
import com.hisun.service.UserService;

/**
 * 
 * @类名： LoginController.java
 * 
 * @描述：LoginController @作者： PAUL @修改日期： 2016年3月28日
 *
 */
@Controller
public class SpaceController
{
    @Resource
    private SpaceService spaceService;

    @Resource
    private UserService userService;


    @RequestMapping(value = "space_show.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceShow(HttpServletRequest request)
    {
        System.out.println("space_show");
        User user = (User) request.getSession().getAttribute("user");
        Space space = null;
        try
        {
            space = this.spaceService.getSpaceByUserId(user.getId());
        }
        catch (SpaceServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model;
        if (space == null)
        {
            model = new ModelAndView("space_add");
        }
        model = new ModelAndView("space_show").addObject("space", space);
        return model;

    }


    @RequestMapping(value = "space_add.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceAdd(HttpServletRequest request)
    {
        System.out.println("space_edit.xhtml");
        User user = (User) request.getSession().getAttribute("user");
        Space space = null;
        try
        {
            space = this.spaceService.getSpaceByUserId(user.getId());
        }
        catch (SpaceServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("space_add").addObject("space", space);
        return model;
    }


    @RequestMapping(value = "space_icon.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceIcom()
    {
        System.out.println("space_icon.xhtml");
        ModelAndView model = new ModelAndView("space_icon");
        return model;
    }


    @RequestMapping(value = "space_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceEdit()
    {
        System.out.println("space_edit.xhtml");
        ModelAndView model = new ModelAndView("space_edit");
        return model;
    }


    @RequestMapping(value = "uploadHeadImage", method = RequestMethod.POST)
    public ModelAndView uploadHeadImage(HttpServletRequest request, @RequestParam(value = "x") int x, @RequestParam(value = "y") int y, @RequestParam(value = "h") int h,
        @RequestParam(value = "w") int w, @RequestParam(value = "imgFile") MultipartFile imageFile) throws Exception
    {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String resourcePath = "images/icons/";
        String path = realPath + resourcePath;
        User user = (User) request.getSession().getAttribute("user");
        if (!imageFile.isEmpty())
        {
            String saveName = user.getCdkey();
            File dir = new File(path, saveName + "_src.jpg");
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            imageFile.transferTo(dir);
            String srcImagePath = path + saveName;
            ImageUtil.imgCut(srcImagePath, x, y, w, h);
        }
        ModelAndView model = new ModelAndView("space_icon");
        return model;
    }


    @RequestMapping(value = "save_space_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveSpaceInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "school", required = false) String school, @RequestParam(value = "college", required = false) String college,
        @RequestParam(value = "major", required = false) String major, @RequestParam(value = "banbie", required = false) String banbie,
        @RequestParam(value = "studentId", required = false) String studentId, @RequestParam(value = "admissionDate", required = false) Date admissionDate,
        @RequestParam(value = "birthday", required = false) Date birthday, @RequestParam(value = "address", required = false) String address,
        @RequestParam(value = "name", required = false) String name, @RequestParam(value = "qq", required = false) String qq, @RequestParam(value = "phone", required = false) String phone,
        @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "hobbies", required = false) String hobbies,
        @RequestParam(value = "inttroduction", required = false) String inttroduction) throws Exception
    {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        user.setStudentid(studentId);
        user.setName(name);
        user.setSex(sex);
        user.setQq(qq);
        user.setPhone(phone);
        System.out.println("phone :" + phone);

        this.userService.updateUser(user);
        System.out.println(user);

        Space space = (id == null ? new Space() : this.spaceService.getSpaceById(id));
        space.setSchool(school);
        space.setCollege(college);
        space.setMajor(major);
        space.setBanbie(banbie);
        space.setAdmissiondate(admissionDate);
        space.setBirthday(birthday);
        space.setAddress(address);
        space.setHobbies(hobbies);
        space.setInttroduction(inttroduction);
        space.setUserid(user.getId());
        if (id == null)
        {
            space.setCreatedate(new Date());
            this.spaceService.insertSpace(space);
        }
        else
        {
            this.spaceService.updateSpace(space);
        }
        return new ResultObject();
    }

}
