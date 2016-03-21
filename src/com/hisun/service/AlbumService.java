package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Album;

/**
 * 
 * @类名： AlbumService.java
 * @描述：AlbumService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface AlbumService
{
    void insertAlbum(Album album);


    void deleteAlbumById(Long id);


    void updateAlbum(Album album);


    Album getAlbumById(Long id);


    List<Album> getAllAlbum();


    List<Album> getAlbumByParams(Map<String, Object> params);
}
