package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Space;
import com.hisun.common.exception.SpaceServiceException;

/**
 * 
 * @类名： SpaceService.java
 * 
 * @描述：SpaceService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface SpaceService
{
    void insertSpace(Space space) throws SpaceServiceException;


    void deleteSpaceById(Long id) throws SpaceServiceException;


    void updateSpace(Space space) throws SpaceServiceException;


    Space getSpaceById(Long id) throws SpaceServiceException;


    Space getSpaceByUserId(Long userId) throws SpaceServiceException;


    List<Space> getAllSpace() throws SpaceServiceException;


    List<Space> getSpaceByParams(Map<String, Object> params) throws SpaceServiceException;
}
