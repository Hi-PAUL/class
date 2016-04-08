package com.hisun.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Album;
import com.hisun.common.bean.User;
import com.hisun.common.exception.AlbumServiceException;
import com.hisun.common.exception.DataAccessException;
import com.hisun.dao.AlbumDao;
import com.hisun.service.AlbumService;

/**
 * 
 * @类名： AlbumServiceImpl.java
 * 
 * @描述：AlbumServiceImpl @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Repository
public class AlbumServiceImpl implements AlbumService
{
    @Resource
    private AlbumDao albumDao;


    @Override
    public void insertAlbum(Album album) throws AlbumServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deleteAlbumById(Long id) throws AlbumServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updateAlbum(Album album) throws AlbumServiceException
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Album getAlbumById(Long id) throws AlbumServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Album> getAlbumByClassId(Long classid) throws AlbumServiceException
    {
        List<Album> list = null;
        try
        {
            list = this.albumDao.getAlbumByClassId(classid);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Album> getAllAlbum() throws AlbumServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Album> getAlbumByParams(Map<String, Object> params) throws AlbumServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void saveAlbum(User user, String albumname, String albumdesc) throws AlbumServiceException
    {
        Album album = new Album();
        album.setAlbumname(albumname);
        album.setAlbumdesc(albumdesc);
        album.setImagefm(user.getUsername());
        album.setClassid(user.getClassid());
        album.setCreatedate(new Date());
        try
        {
            this.albumDao.insertAlbum(album);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            throw new AlbumServiceException(e.getMessage());
        }
    }

}
