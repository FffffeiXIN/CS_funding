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
@Api(tags = "User Test")
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

    @PostMapping("/getAllUsers")
    @ApiOperation(value = "Get All Users")
    public Result getAllUsers() {
        return userService.getAllUsers();
    }
}
