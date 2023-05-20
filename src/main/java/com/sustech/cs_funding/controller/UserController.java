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
}
