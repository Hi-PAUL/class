package com.hisun.web.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Photo;
import com.hisun.common.bean.User;
import com.hisun.common.exception.PhotoServiceException;
import com.hisun.common.util.RandomChar;
import com.hisun.common.util.ResultObject;
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


    @RequestMapping(value = "photo_update.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPhotoUpdate(HttpServletRequest request, @RequestParam(value = "albumid", required = false) Long albumid)
    {
        System.out.println("photo_list");
        ModelAndView model = new ModelAndView("photo_update").addObject("albumid", albumid);
        return model;
    }


    @RequestMapping(value = "photo_list.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPhotoList(HttpServletRequest request)
    {
        System.out.println("photo_list");
        ModelAndView model = new ModelAndView("admin/photo_list");
        return model;
    }


    @RequestMapping(value = "save_photo.action", method = RequestMethod.POST)
    public ModelAndView savePhoto(HttpServletRequest request, MultipartFile photofile, @RequestParam(value = "title", required = false) String title,
        @RequestParam(value = "contents", required = false) String contents, @RequestParam(value = "albumid", required = false) Long albumid) throws Exception
    {
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


    @RequestMapping(value = "get_photo_list.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getResultList(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "author", required = false) String author,
        @RequestParam(value = "title", required = false) String title)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.photoService.getPhotoList(pageNumber, pageSize, author, title);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "photo_edit.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoPhotoEdit(HttpServletRequest request, @RequestParam(value = "operType") String operType, @RequestParam(value = "id", required = false) String id,
        @RequestParam(value = "pageNumber", required = false) String pageNumber)
    {
        return new ModelAndView("admin/photo_edit").addObject("operType", operType).addObject("id", id).addObject("pageNumber", pageNumber);
    }


    @RequestMapping(value = "get_photo_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject getPhotoById(@RequestParam(value = "id") Long id)
    {
        Photo photo = null;
        try
        {
            photo = this.photoService.getPhotoById(id);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject(photo);
    }


    @RequestMapping(value = "save_photo_info.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveClassInfo(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "author", required = false) String author,
        @RequestParam(value = "path", required = false) String path, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "contents", required = false) String contents,
        @RequestParam(value = "albumname", required = false) String albumname)
    {
        try
        {
            this.photoService.savePhotoInfo(id, author, path, title, contents, albumname);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }


    @RequestMapping(value = "delete_photo_by_id.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject deletePhotoById(@RequestParam(value = "id") Long id)
    {
        try
        {
            this.photoService.deletePhotoById(id);
        }
        catch (PhotoServiceException e)
        {
            e.printStackTrace();
        }
        return new ResultObject();
    }

}
