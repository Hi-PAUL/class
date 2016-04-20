package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.PointAction;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： PointActionDao.java
 * 
 * @描述：PointActionDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface PointActionDao
{
    void insertPointAction(PointAction PointAction) throws DataAccessException;


    void deletePointActionById(Long id) throws DataAccessException;


    void updatePointAction(PointAction PointAction) throws DataAccessException;


    PointAction getPointActionById(Long id) throws DataAccessException;


    Integer getPointActionByActionname(String actionname) throws DataAccessException;


    List<PointAction> getAllPointAction() throws DataAccessException;


    List<PointAction> getPointActionByParams(Map<String, Object> params) throws DataAccessException;
}
