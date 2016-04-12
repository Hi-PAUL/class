package com.hisun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
        try
        {
            this.photoDao.deletePhotoById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updatePhoto(Photo photo) throws PhotoServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Photo getPhotoById(Long id) throws PhotoServiceException
    {
        Photo photo = null;
        try
        {
            photo = this.photoDao.getPhotoById(id);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return photo;
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


    @Override
    public Map<String, Object> getPhotoList(Integer pageNumber, Integer pageSize, String author, String title) throws PhotoServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(author))
        {
            params.put("author", author);
        }
        if (StringUtils.isNotEmpty(title))
        {
            params.put("title", title);
        }
        List<Photo> photoList = null;
        try
        {
            photoList = this.photoDao.getPhotoByParams(params);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        Integer fromRecord = (pageNumber - 1) * pageSize;
        Integer endRecord = photoList.size() < fromRecord + pageSize ? photoList.size() : fromRecord + pageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", photoList == null ? null : photoList.subList(fromRecord, endRecord));
        map.put("total", photoList == null ? 0 : photoList.size());
        return map;
    }


    @Override
    public void savePhotoInfo(Long id, String author, String path, String title, String contents, String albumname) throws PhotoServiceException
    {

        Photo photo = null;
        try
        {
            photo = (id == null ? new Photo() : this.photoDao.getPhotoById(id));
            photo.setAuthor(author);
            photo.setPath(path);
            photo.setTitle(title);
            photo.setContents(contents);
            photo.setAlbumname(albumname);
            photo.setAlbumid(1L);
            if (id == null)
            {
                photo.setPubdate(new Date());
                this.photoDao.insertPhoto(photo);
            }
            else
            {
                this.photoDao.updatePhoto(photo);
            }
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        
        
    }

}
