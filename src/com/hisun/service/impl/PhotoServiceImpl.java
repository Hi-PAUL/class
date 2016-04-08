package com.hisun.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Photo;
import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;
import com.hisun.common.exception.PhotoServiceException;
import com.hisun.dao.PhotoDao;
import com.hisun.service.PhotoService;

/**
 * 
 * @类名： PhotoServiceImpl.java
 * 
 * @描述：PhotoServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class PhotoServiceImpl implements PhotoService
{
    @Resource
    private PhotoDao photoDao;


    @Override
    public void insertPhoto(Photo photo) throws PhotoServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deletePhotoById(Long id) throws PhotoServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updatePhoto(Photo photo) throws PhotoServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Photo getPhotoById(Long id) throws PhotoServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Photo> getPhotoByAlbumId(Long albumid) throws PhotoServiceException
    {
        List<Photo> list = null;
        try
        {
            list = this.photoDao.getPhotoByAlbumId(albumid);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Photo> getAllPhoto() throws PhotoServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Photo> getPhotoByParams(Map<String, Object> params) throws PhotoServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void savePhoto(User user, String saveName, String title, String contents, Long albumid) throws PhotoServiceException
    {
        Photo photo = new Photo();
        photo.setAuthor(user.getUsername());
        photo.setPath(saveName);
        photo.setTitle(title);
        photo.setContents(contents);
        photo.setAlbumid(albumid);
        photo.setPubdate(new Date());
        try
        {
            this.photoDao.insertPhoto(photo);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

}
