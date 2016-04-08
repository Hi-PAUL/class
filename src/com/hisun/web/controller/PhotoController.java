package com.hisun.web.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Photo;
import com.hisun.common.bean.User;
import com.hisun.common.exception.PhotoServiceException;
import com.hisun.common.util.RandomChar;
import com.hisun.service.PhotoService;

/**
 * 
 * @类名： PhotoController.java
 * 
 * @描述：PhotoController @作者： PAUL @修改日期： 2016年4月8日
 *
 */
@Controller
public class PhotoController
{
    @Resource
    private PhotoService photoService;


    @RequestMapping(value = "photo.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPhoto(HttpServletRequest request, @RequestParam(value = "albumid", required = false) Long albumid)
    {
        System.out.println("photo");
        List<Photo> list = null;
        try
        {
            list = this.photoService.getPhotoByAlbumId(albumid);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("photo").addObject("albumid", albumid).addObject("photoList", list);
        return model;
    }


    @RequestMapping(value = "save_photo.action", method = RequestMethod.POST)
    public ModelAndView savePhoto(HttpServletRequest request, @RequestParam(value = "photofile", required = false) MultipartFile photofile,
        @RequestParam(value = "title", required = false) String title, @RequestParam(value = "contents", required = false) String contents,
        @RequestParam(value = "albumid", required = false) Long albumid) throws Exception
    {
        System.out.println(title);
        System.out.println(albumid);
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String resourcePath = "images/icons/";
        String path = realPath + resourcePath;
        String saveName = RandomChar.getChars(4, 32) + ".jpg";
        User user = (User) request.getSession().getAttribute("user");
        if (!photofile.isEmpty())
        {
            File dir = new File(path, saveName);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            photofile.transferTo(dir);
        }
        try
        {
            this.photoService.savePhoto(user, saveName, title, contents, albumid);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("photo");
        return model;
    }

}
