package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Result;

/**
 * 
 * @类名： ResultDao.java
 * @描述：ResultDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface ResultDao
{
    void insertResult(Result Result);


    void deleteResultById(Long id);


    void updateResult(Result Result);


    Result getResultById(Long id);


    List<Result> getAllResult();


    List<Result> getResultByParams(Map<String, Object> params);
}
