package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "UserController")
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping("/login")
    @ApiOperation(value = "User Login")
    public Result login(Integer id, String password) {
        return userService.login(id, password);
    }
    
    @GetMapping("/delete")
    @ApiOperation(value = "Delete a user by its id")
    public Result delete(Integer id) {
        return userService.delete(id);
    }

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "Get All Users")
    public Result getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getAllUsersByGroup")
    @ApiOperation(value = "Get All Users")
    public Result getAllUsersByGroup(String group) {
        return userService.getAllUsersByGroup(group);
    }

    @GetMapping("/blockUser")
    @ApiOperation(value = "Block User")
    public Result blockUser(String sid) {
        return userService.blockUser(sid);
    }

    @GetMapping("/unBlockUser")
    @ApiOperation(value = "Unblock User")
    public Result unBlockUser(String sid) {
        return userService.unBlockUser(sid);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register new user")
    public Result register(String name, Integer sid, String password, String role, String email) {
        return userService.register(name, sid, password, role, email);
    }
    
    @PostMapping("/modifyPasswd")
    @ApiOperation(value = "Modify user's password.")
    public Result modifyPasswd(Integer sid, String password) {
        return userService.modifyPasswd(sid, password);
    }
    
    @GetMapping("insertGroup")
    @ApiOperation(value = "insert research group relationship of specific user")
    public Result insertGroup(int userid, String group) {
        return userService.insertGroup(userid, group);
    }

    @GetMapping("deleteGroup")
    @ApiOperation(value = "delete research group relationship of specific user")
    public Result deleteGroup(int userid, String group) {
        return userService.deleteGroup(userid, group);
    }

    @GetMapping("updateRole")
    @ApiOperation(value = "update research group relationship of specific user")
    public Result updateRole(int userid, String role) {
        return userService.updateRole(userid, role);
    }

    @GetMapping("updateEmail")
    @ApiOperation(value = "update email of specific user")
    public Result updateEmail(int userid, String email) {
        return userService.updateEmail(userid, email);
    }
    
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "get the personal information of specific user")
    public Result getUserInfo(int userid) {
        return userService.getUserInfo(userid);
    }

    @GetMapping("getGroupInfo")
    @ApiOperation(value = "get corresponding research groups of specific user")
    public Result getGroupInfo(int userid) {
        return userService.getGroupInfo(userid);
    }
}
