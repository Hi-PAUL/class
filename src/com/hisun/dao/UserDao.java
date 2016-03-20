package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.User;

@Repository
public interface UserDao
{
    int deleteByPrimaryKey(Long id);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);
}
