package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Admin;

/**
 * 
 * @类名： AdminService.java
 * @描述：AdminService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface AdminService
{
    void insertAdmin(Admin admin);


    void deleteAdminById(Long id);


    void updateAdmin(Admin admin);


    Admin getAdminById(Long id);


    List<Admin> getAllAdmin();


    List<Admin> getAdminByParams(Map<String, Object> params);
}
