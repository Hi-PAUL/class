package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Result;

@Repository
public interface ResultDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Result record);


    int insertSelective(Result record);


    Result selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Result record);


    int updateByPrimaryKey(Result record);
}
