package com.hisun.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView gotoAlbum()
    {
        System.out.println("album");
        ModelAndView model = new ModelAndView("album");
        return model;
    }

}
