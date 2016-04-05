package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Class;
import com.hisun.common.exception.ClassServiceException;

/**
 * 
 * @类名： ClassService.java
 * 
 * @描述：ClassService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface ClassService
{
    void insertClass(Class clas) throws ClassServiceException;


    void deleteClassById(Long id) throws ClassServiceException;


    void updateClass(Class clas) throws ClassServiceException;


    Class getClassById(Long id) throws ClassServiceException;


    List<Class> getAllClass() throws ClassServiceException;


    List<Class> getClassByParams(Map<String, Object> params) throws ClassServiceException;
}
