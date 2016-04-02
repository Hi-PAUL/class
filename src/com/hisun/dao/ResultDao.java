package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Result;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： ResultDao.java
 * 
 * @描述：ResultDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface ResultDao
{
    void insertResult(Result Result) throws DataAccessException;


    void deleteResultById(Long id) throws DataAccessException;


    void updateResult(Result Result) throws DataAccessException;


    Result getResultById(Long id) throws DataAccessException;


    List<Result> getAllResult() throws DataAccessException;


    List<Result> getResultByParams(Map<String, Object> params) throws DataAccessException;
}
