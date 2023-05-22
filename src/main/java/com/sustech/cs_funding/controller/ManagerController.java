package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.manager.ManagerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("/moneyAllocation")
    @ApiOperation(value = "Manager to allocate the money")
    public Result moneyAllocation(String group_name, String fund_name, Double total) {
        return managerService.moneyAllocation(group_name, fund_name, total);
    }
    
    @GetMapping("/totalMoneyAllocation")
    @ApiOperation(value = "Manager to allocate the total money")
    public Result totalMoneyAllocation(String code, Double total) {
        return managerService.totalmoneyAllocation(code, total);
    }

    @GetMapping("/totalMoneyCheck")
    @ApiOperation(value = "check the value of total_available")
    public Result totalMoneyCheck(String code) {
        return managerService.totalmoneyCheck(code);
    }

    @GetMapping("/getFundsInfo")
    @ApiOperation(value = "get funds name, code, total money, ...")
    public Result getFundsInfo() {
        return managerService.getFundsInfo();
    }
}
