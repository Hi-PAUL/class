package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Photo;
import com.hisun.common.bean.User;
import com.hisun.common.exception.PhotoServiceException;

/**
 * 
 * @类名： PhotoService.java
 * 
 * @描述：PhotoService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface PhotoService
{
    void insertPhoto(Photo photo) throws PhotoServiceException;


    void deletePhotoById(Long id) throws PhotoServiceException;


    void updatePhoto(Photo photo) throws PhotoServiceException;


    Photo getPhotoById(Long id) throws PhotoServiceException;


    List<Photo> getPhotoByAlbumId(Long albumid) throws PhotoServiceException;


    List<Photo> getAllPhoto() throws PhotoServiceException;


    List<Photo> getPhotoByParams(Map<String, Object> params) throws PhotoServiceException;


    void savePhoto(User user, String saveName, String title, String contents, Long albumid) throws PhotoServiceException;


    Map<String, Object> getPhotoList(Integer pageNumber, Integer pageSize, String author, String title) throws PhotoServiceException;


    void savePhotoInfo(Long id, String author, String path, String title, String contents, String albumname) throws PhotoServiceException;
}
