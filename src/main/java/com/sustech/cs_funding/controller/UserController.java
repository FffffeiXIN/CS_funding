package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "User Test")
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping("/login")
    @ApiOperation(value = "User Login")
    public Result login(int id, String password) {
        return userService.login(id, password);
    }

    @PostMapping("/getAllUsers")
    @ApiOperation(value = "Get All Users")
    public Result getAllUsers() {
        return userService.getAllUsers();
    }
}
