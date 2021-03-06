package com.hisun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hisun.common.bean.User;
import com.hisun.common.exception.DataAccessException;

/**
 * 
 * @类名： UserDao.java
 * 
 * @描述：UserDao @作者： PAUL @修改日期： 2016年3月20日
 *
 */
@Repository
public interface UserDao
{

    void insertUser(User user);


    void deleteUserById(Long id)throws DataAccessException;


    void updateUser(User User);


    User getUserById(Long id);


    User getUserByUsername(String username) throws DataAccessException;


    List<User> getAllUser();


    List<User> getUserByParams(Map<String, Object> params) throws DataAccessException;

}
