package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.PointAction;

/**
 * 
 * @类名： PointActionDao.java
 * @描述：PointActionDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface PointActionDao
{
    void insertPointAction(PointAction PointAction);


    void deletePointActionById(Long id);


    void updatePointAction(PointAction PointAction);


    PointAction getPointActionById(Long id);


    List<PointAction> getAllPointAction();


    List<PointAction> getPointActionByParams(Map<String, Object> params);
}
