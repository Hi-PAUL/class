package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Photo;

/**
 * 
 * @类名： PhotoService.java
 * @描述：PhotoService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface PhotoService
{
    void insertPhoto(Photo photo);


    void deletePhotoById(Long id);


    void updatePhoto(Photo photo);


    Photo getPhotoById(Long id);


    List<Photo> getAllPhoto();


    List<Photo> getPhotoByParams(Map<String, Object> params);
}
