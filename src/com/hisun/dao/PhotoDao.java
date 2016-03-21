package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Photo;

/**
 * 
 * @类名： PhotoDao.java
 * @描述：PhotoDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface PhotoDao
{
    void insertPhoto(Photo Photo);


    void deletePhotoById(Long id);


    void updatePhoto(Photo Photo);


    Photo getPhotoById(Long id);


    List<Photo> getAllPhoto();


    List<Photo> getPhotoByParams(Map<String, Object> params);
}
