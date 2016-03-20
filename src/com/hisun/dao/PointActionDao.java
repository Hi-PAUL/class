package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.PointAction;

@Repository
public interface PointActionDao
{
    int deleteByPrimaryKey(Long id);


    int insert(PointAction record);


    int insertSelective(PointAction record);


    PointAction selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(PointAction record);


    int updateByPrimaryKey(PointAction record);
}
