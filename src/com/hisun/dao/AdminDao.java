package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Admin;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： AdminDao.java
 * 
 * @描述：AdminDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface AdminDao
{
    void insertAdmin(Admin Admin) throws DataAccessException;


    void deleteAdminById(Long id) throws DataAccessException;


    void updateAdmin(Admin Admin) throws DataAccessException;


    Admin getAdminById(Long id) throws DataAccessException;


    Admin getAdminByAdminName(String adminname) throws DataAccessException;


    List<Admin> getAllAdmin() throws DataAccessException;


    List<Admin> getAdminByParams(Map<String, Object> params) throws DataAccessException;
}
