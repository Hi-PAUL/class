package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Space;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： SpaceDao.java
 * 
 * @描述：SpaceDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface SpaceDao
{
    void insertSpace(Space Space) throws DataAccessException;


    void deleteSpaceById(Long id) throws DataAccessException;


    void updateSpace(Space Space) throws DataAccessException;


    Space getSpaceById(Long id) throws DataAccessException;


    Space getSpaceByUserId(Long userId) throws DataAccessException;


    List<Space> getAllSpace() throws DataAccessException;


    List<Space> getSpaceByParams(Map<String, Object> params) throws DataAccessException;
}
