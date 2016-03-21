package com.hisun.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hisun.common.bean.User;

/**
 * 
 * @类名： UserService.java
 * @描述：UserService
 * @作者： PAUL
 * @修改日期： 2016年3月22日
 *
 */
@Service
public interface UserService
{
    void insertUser(User user);


    void deleteUserById(Long id);


    void updateUser(User User);


    User getUserById(Long id);


    List<User> getAllUser();


    List<User> getUserByParams(Map<String, Object> params);
}
