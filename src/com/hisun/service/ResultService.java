package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Result;

/**
 * 
 * @类名： ResultService.java
 * @描述：ResultService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface ResultService
{
    void insertResult(Result result);


    void deleteResultById(Long id);


    void updateResult(Result result);


    Result getResultById(Long id);


    List<Result> getAllResult();


    List<Result> getResultByParams(Map<String, Object> params);
}
