package com.hisun.dao;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Album;

@Repository
public interface AlbumDao
{
    int deleteByPrimaryKey(Long id);


    int insert(Album record);


    int insertSelective(Album record);


    Album selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Album record);


    int updateByPrimaryKey(Album record);
}
