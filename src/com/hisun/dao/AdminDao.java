package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.Admin;

/**
 * 
 * @类名： AdminDao.java
 * @描述：AdminDao
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
@Repository
public interface AdminDao
{
    void insertAdmin(Admin Admin);


    void deleteAdminById(Long id);


    void updateAdmin(Admin Admin);


    Admin getAdminById(Long id);


    List<Admin> getAllAdmin();


    List<Admin> getAdminByParams(Map<String, Object> params);
}
