package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Admin;

@Repository
public interface AdminDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Admin record);


    int insertSelective(Admin record);


    Admin selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Admin record);


    int updateByPrimaryKey(Admin record);
}
