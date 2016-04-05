package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Class;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： ClassDao.java
 * 
 * @描述：ClassDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface ClassDao
{
    void insertClass(Class Class) throws DataAccessException;


    void deleteClassById(Long id) throws DataAccessException;


    void updateClass(Class Class) throws DataAccessException;


    Class getClassById(Long id) throws DataAccessException;


    List<Class> getAllClass() throws DataAccessException;


    List<Class> getClassByParams(Map<String, Object> params) throws DataAccessException;
}
