package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Result;
import com.hisun.common.exception.ResultServiceException;

/**
 * 
 * @类名： ResultService.java
 * 
 * @描述：ResultService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface ResultService
{
    void insertResult(Result result) throws ResultServiceException;


    void deleteResultById(Long id) throws ResultServiceException;


    void updateResult(Result result) throws ResultServiceException;


    Result getResultById(Long id) throws ResultServiceException;


    List<Result> getAllResult() throws ResultServiceException;


    List<Result> getResultByParams(String studentId, String session) throws ResultServiceException;


    Map<String, Object> getResultList(Integer pageNumber, Integer pageSize, String studentId, String banbie, String session, String coursename) throws ResultServiceException;


    void saveResultInfo(Long id, String studentid, String banbie, String name, String session, String coursename, String coursecode, Integer period, Integer credit, Double scores, String remark)
        throws ResultServiceException;
}
