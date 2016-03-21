package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Space;

/**
 * 
 * @类名： SpaceService.java
 * @描述：SpaceService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface SpaceService
{
    void insertSpace(Space space);


    void deleteSpaceById(Long id);


    void updateSpace(Space space);


    Space getSpaceById(Long id);


    List<Space> getAllSpace();


    List<Space> getSpaceByParams(Map<String, Object> params);
}
