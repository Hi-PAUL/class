package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Message;

@Repository
public interface MessageDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Message record);


    int insertSelective(Message record);


    Message selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Message record);


    int updateByPrimaryKey(Message record);
}
