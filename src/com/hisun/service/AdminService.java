package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.Admin;
import com.hisun.common.exception.AdminServiceException;

/**
 * 
 * @类名： AdminService.java
 * 
 * @描述：AdminService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface AdminService
{

    Admin adminLogin(String adminname, String password) throws AdminServiceException;


    void insertAdmin(Admin admin) throws AdminServiceException;


    void deleteAdminById(Long id) throws AdminServiceException;


    void updateAdmin(Admin admin) throws AdminServiceException;


    Admin getAdminById(Long id) throws AdminServiceException;


    List<Admin> getAllAdmin() throws AdminServiceException;


    List<Admin> getAdminByParams(Map<String, Object> params) throws AdminServiceException;


    Map<String, Object> getAdminList(Integer pageNumber, Integer pageSize, String adminname, String name) throws AdminServiceException;


    void saveAdminInfo(Long id, String adminname, String password, String sex, String phone, String email, Integer level, Integer status, String name) throws AdminServiceException;


    void saveAdminPassword(Admin admin, String oldpassword, String newpassword) throws AdminServiceException;
}
