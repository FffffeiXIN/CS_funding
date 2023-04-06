package com.sustech.cs_funding.service.user;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    
    public Result login(int id, String password) {
        return Result.ok().addData("loginResult", userMapper.login(id, password));
    }
}
