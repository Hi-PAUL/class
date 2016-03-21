package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Class;

/**
 * 
 * @类名： ClassService.java
 * @描述：ClassService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface ClassService
{
    void insertClass(Class clas);


    void deleteClassById(Long id);


    void updateClass(Class clas);


    Class getClassById(Long id);


    List<Class> getAllClass();


    List<Class> getClassByParams(Map<String, Object> params);
}
