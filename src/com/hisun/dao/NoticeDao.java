package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Notice;

@Repository
public interface NoticeDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Notice record);


    int insertSelective(Notice record);


    Notice selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Notice record);


    int updateByPrimaryKey(Notice record);
}
