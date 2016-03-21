package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.PointAction;

/**
 * 
 * @类名： PointActionService.java
 * @描述：PointActionService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface PointActionService
{
    void insertPointAction(PointAction pointAction);


    void deletePointActionById(Long id);


    void updatePointAction(PointAction pointAction);


    PointAction getPointActionById(Long id);


    List<PointAction> getAllPointAction();


    List<PointAction> getPointActionByParams(Map<String, Object> params);
}
