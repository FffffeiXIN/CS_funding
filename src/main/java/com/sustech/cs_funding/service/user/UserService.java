package com.sustech.cs_funding.service.user;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.User;
import com.sustech.cs_funding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    
    public Result login(Integer id, String password) {
        List<User> res = userMapper.login(id, password);
        if (res.isEmpty()) {
            return Result.error().code(400).message("Wrong password");
        }
        else if (res.get(0).getStatus().equals("blocked"))
            return Result.error().code(300).message("User blocked");
        return Result.ok().code(200).message("Refer to loginResult")
                .addData("user", userMapper.login(id, password))
                .addData("group", userMapper.getGroup(id));
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

    public Result unBlockUser(String sid) {
        int id = Integer.parseInt(sid);
        return Result.ok().addData("unBlockResult", userMapper.unBlockUser(id));
    }

    public Result register(String name, Integer sid, String password, String role, String email) {
    try {
        userMapper.register(name, sid, password, role, email);
        return Result.ok().code(200).addData("result", true);
    } catch (DuplicateKeyException e) {
        return Result.ok().code(200).addData("result", false);
    }
    }

    public Result modifyPasswd(Integer sid, String password) {
        return Result.ok().code(200).addData("result", userMapper.modifyPasswd(sid, password));
    }
    
    public Result getUserInfo(int userid) {
        User user_info = userMapper.getUserById(userid);
        return Result.ok().code(200).message("Success").addData("user_info", user_info);
    }

    public Result getGroupInfo(int userid) {
        List<String> groups_info = userMapper.getGroup(userid);
        return Result.ok().code(200).message("Success").addData("groups_info", groups_info);
    }

    public Result insertGroup(int userid, String group) {
        userMapper.insertGroup(userid, group);
        return Result.ok().code(200).message("Success");
    }

    public Result deleteGroup(int userid, String group) {
        userMapper.deleteGroup(userid, group);
        return Result.ok().code(200).message("Success");
    }

    public Result updateRole(int userid, String role) {
        userMapper.updateRole(userid, role);
        return Result.ok().code(200).message("Success");
    }

    public Result updateEmail(int userid, String email) {
        userMapper.updateEmail(userid, email);
        return Result.ok().code(200).message("Success");
    }

    public Result updateAvatar(int userid, String avatar) {
        userMapper.updateAvatar(userid, avatar);
        return Result.ok().code(200).message("Success");
    }

    public Result updateOnline(int userid, boolean online) {
        userMapper.updateOnline(userid, online);
        return Result.ok().code(200).message("Success");
    }

    public Result getOnlineUsers() {
        List<User> onlineUsers = userMapper.getOnlineUsers();
        return Result.ok().code(200).message("Success").addData("online_users", onlineUsers);
    }
}
