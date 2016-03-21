package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Album;

/**
 * 
 * @类名： AlbumDao.java
 * @描述：AlbumDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface AlbumDao
{
    void insertAlbum(Album Album);


    void deleteAlbumById(Long id);


    void updateAlbum(Album Album);


    Album getAlbumById(Long id);


    List<Album> getAllAlbum();


    List<Album> getAlbumByParams(Map<String, Object> params);
}
