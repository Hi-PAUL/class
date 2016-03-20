package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Photo;

@Repository
public interface PhotoDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Photo record);


    int insertSelective(Photo record);


    Photo selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Photo record);


    int updateByPrimaryKey(Photo record);
}
