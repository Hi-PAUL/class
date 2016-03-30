package com.hisun.web.controller;

import java.io.File;

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

import com.hisun.common.bean.User;
import com.hisun.common.util.ImageUtil;
import com.hisun.common.util.ResultObject;
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
    private UserService userService;


    @RequestMapping(value = "space_show.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceShow()
    {
        System.out.println("space_show");
        ModelAndView model = new ModelAndView("space_show");
        return model;
    }


    @RequestMapping(value = "space_add.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoSpaceAdd()
    {
        System.out.println("space_edit.xhtml");
        ModelAndView model = new ModelAndView("space_add");
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
    public ResultObject saveSpaceInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "password", required = false) String password, @RequestParam(value = "authCode", required = false) String authCode,
        @RequestParam(value = "autoLogin", required = false) int autoLogin) throws Exception
    {
        String code = (String) request.getSession().getAttribute("authCode");
        System.out.println(code);
        System.err.println(authCode);

        return new ResultObject();
    }

}
