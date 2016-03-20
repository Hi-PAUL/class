package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Class;

@Repository
public interface ClassDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Class record);


    int insertSelective(Class record);


    Class selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Class record);


    int updateByPrimaryKey(Class record);
}
