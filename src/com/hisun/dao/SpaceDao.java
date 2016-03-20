package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Space;

@Repository
public interface SpaceDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Space record);


    int insertSelective(Space record);


    Space selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Space record);


    int updateByPrimaryKey(Space record);
}
