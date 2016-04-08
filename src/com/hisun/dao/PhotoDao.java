package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Photo;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： PhotoDao.java
 * 
 * @描述：PhotoDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface PhotoDao
{
    void insertPhoto(Photo Photo) throws DataAccessException;


    void deletePhotoById(Long id) throws DataAccessException;


    void updatePhoto(Photo Photo) throws DataAccessException;


    Photo getPhotoById(Long id) throws DataAccessException;


    List<Photo> getPhotoByAlbumId(Long albumid) throws DataAccessException;


    List<Photo> getAllPhoto() throws DataAccessException;


    List<Photo> getPhotoByParams(Map<String, Object> params) throws DataAccessException;
}
