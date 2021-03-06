package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.User;
import com.hisun.common.exception.UserServiceException;

/**
 * 
 * @类名： UserService.java
 * 
 * @描述：UserService @作者： PAUL @修改日期： 2016年3月22日
 *
 */
@Service
public interface UserService
{
    User login(String username, String password) throws UserServiceException;


    void register(String username, String password, String email) throws UserServiceException;


    void activate(String username, String cdKey) throws UserServiceException;


    void insertUser(User user);


    void deleteUserById(Long id) throws UserServiceException;


    void updateUser(User User);


    User getUserById(Long id);


    User getUserByUsername(String username) throws UserServiceException;


    List<User> getAllUser();


    List<User> getUserByParams(int isonline, Long classid) throws UserServiceException;


    Map<String, Object> getUserList(Integer pageNumber, Integer pageSize, String username, String name, Long classid) throws UserServiceException;


    void saveUseInfo(Long id, String username, String sex, String qq, String phone, String email, Integer status, Long point, String name, String studentid) throws UserServiceException;

}
