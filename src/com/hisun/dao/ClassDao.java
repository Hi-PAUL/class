package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Class;

/**
 * 
 * @类名： ClassDao.java
 * @描述：ClassDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface ClassDao
{
    void insertClass(Class Class);


    void deleteClassById(Long id);


    void updateClass(Class Class);


    Class getClassById(Long id);


    List<Class> getAllClass();


    List<Class> getClassByParams(Map<String, Object> params);
}
