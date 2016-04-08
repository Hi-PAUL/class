package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Album;
import com.hisun.common.bean.User;
import com.hisun.common.exception.AlbumServiceException;

/**
 * 
 * @类名： AlbumService.java
 * 
 * @描述：AlbumService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface AlbumService
{
    void insertAlbum(Album album) throws AlbumServiceException;


    void deleteAlbumById(Long id) throws AlbumServiceException;


    void updateAlbum(Album album) throws AlbumServiceException;


    Album getAlbumById(Long id) throws AlbumServiceException;


    List<Album> getAlbumByClassId(Long classid) throws AlbumServiceException;


    List<Album> getAllAlbum() throws AlbumServiceException;


    List<Album> getAlbumByParams(Map<String, Object> params) throws AlbumServiceException;


    void saveAlbum(User user, String albumname, String albumdesc) throws AlbumServiceException;
}
