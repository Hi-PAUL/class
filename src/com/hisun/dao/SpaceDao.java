package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Space;

/**
 * 
 * @类名： SpaceDao.java
 * @描述：SpaceDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface SpaceDao
{
    void insertSpace(Space Space);


    void deleteSpaceById(Long id);


    void updateSpace(Space Space);


    Space getSpaceById(Long id);


    List<Space> getAllSpace();


    List<Space> getSpaceByParams(Map<String, Object> params);
}
