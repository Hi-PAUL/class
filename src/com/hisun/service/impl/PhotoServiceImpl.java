package com.hisun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Photo;
import com.hisun.service.PhotoService;

/**
 * 
 * @类名： PhotoServiceImpl.java
 * @描述：PhotoServiceImpl
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Repository
public class PhotoServiceImpl implements PhotoService
{

    @Override
    public void insertPhoto(Photo photo)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void deletePhotoById(Long id)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void updatePhoto(Photo photo)
    {
        // TODO Auto-generated method stub

    }


    @Override
    public Photo getPhotoById(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Photo> getAllPhoto()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Photo> getPhotoByParams(Map<String, Object> params)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
