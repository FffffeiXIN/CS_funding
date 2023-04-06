package com.sustech.cs_funding.service.user;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.User;
import com.sustech.cs_funding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    
    public Result login(Integer id, String password) {
        return Result.ok().code(200).message("Refer to loginResult").addData("loginResult", userMapper.login(id, password));
    }
    
    public Result delete(Integer id) {
        userMapper.delete(id);
        return Result.ok().code(200).message("Deleted");
    }

    public Result getAllUsers() {
        return Result.ok().addData("user", userMapper.getAllUsers());
    }

    public Result getAllUsersByGroup(String group) {
        List<Integer> userID = userMapper.getAllUserIDsByGroup(group);
        List<User> users = new ArrayList<>();

        for (int id : userID) {
            users.add(userMapper.getUserById(id));
        }
        return Result.ok().addData("user", users);
    }

    public Result blockUser(String sid) {
        int id = Integer.parseInt(sid);
        return Result.ok().addData("blockResult", userMapper.blockUser(id));
    }
}
