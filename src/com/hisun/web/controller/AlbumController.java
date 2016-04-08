package com.hisun.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Album;
import com.hisun.common.bean.User;
import com.hisun.common.exception.AlbumServiceException;
import com.hisun.common.util.ResultObject;
import com.hisun.service.AlbumService;

/**
 * 
 * @类名： AlbumController.java
 * 
 * @描述：AlbumController @作者： PAUL @修改日期： 2016年4月6日
 *
 */
@Controller
public class AlbumController
{
    @Resource
    private AlbumService albumService;


    @RequestMapping(value = "album.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoAlbum(HttpServletRequest request)
    {
        System.out.println("album");
        User user = (User) request.getSession().getAttribute("user");
        List<Album> list = null;
        try
        {
            list = this.albumService.getAlbumByClassId(user.getClassid());
        }
        catch (AlbumServiceException e)
        {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("album").addObject("albumList", list);
        return model;
    }


    @RequestMapping(value = "save_album.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject saveAlbum(HttpServletRequest request, @RequestParam(value = "albumname", required = false) String albumname,
        @RequestParam(value = "albumdesc", required = false) String albumdesc)
    {

        User user = (User) request.getSession().getAttribute("user");

        try
        {
            this.albumService.saveAlbum(user, albumname, albumdesc);
        }
        catch (AlbumServiceException e)
        {
            e.printStackTrace();
            return new ResultObject(110, e.getMessage());
        }
        return new ResultObject();
    }

}
