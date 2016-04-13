package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.PointAction;
import com.hisun.common.exception.PointActionServiceException;

/**
 * 
 * @类名： PointActionService.java
 * 
 * @描述：PointActionService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface PointActionService
{
    void insertPointAction(PointAction pointAction) throws PointActionServiceException;


    void deletePointActionById(Long id) throws PointActionServiceException;


    void updatePointAction(PointAction pointAction) throws PointActionServiceException;


    PointAction getPointActionById(Long id) throws PointActionServiceException;


    List<PointAction> getAllPointAction() throws PointActionServiceException;


    List<PointAction> getPointActionByParams(Map<String, Object> params) throws PointActionServiceException;


    Map<String, Object> getPointActionList(Integer pageNumber, Integer pageSize, String actionname) throws PointActionServiceException;


    void savePointActionInfo(Long id, String actionname, Integer point, String description) throws PointActionServiceException;
}
