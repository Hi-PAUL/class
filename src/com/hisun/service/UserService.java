package com.hisun.service;


import org.springframework.stereotype.Service;

import com.hisun.common.bean.User;

@Service
public interface UserService
{

	User selectByPrimaryKey(Long id);
}
