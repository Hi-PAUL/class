package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Album;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： AlbumDao.java
 * 
 * @描述：AlbumDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface AlbumDao
{
    void insertAlbum(Album Album) throws DataAccessException;


    void deleteAlbumById(Long id) throws DataAccessException;


    void updateAlbum(Album Album) throws DataAccessException;


    Album getAlbumById(Long id) throws DataAccessException;


    List<Album> getAlbumByClassId(Long classid) throws DataAccessException;


    List<Album> getAllAlbum() throws DataAccessException;


    List<Album> getAlbumByParams(Map<String, Object> params) throws DataAccessException;
}
